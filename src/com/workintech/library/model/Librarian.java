package com.workintech.library.model;

import com.workintech.library.enums.BookStatus;
import com.workintech.library.manager.BookManager;
import com.workintech.library.manager.BorrowManager;
import com.workintech.library.manager.MemberManager;

public class Librarian extends Person {

    private String password;
    private BookManager bookManager;
    private MemberManager memberManager;
    private BorrowManager borrowManager;

    public Librarian(String name, String password,
                     BookManager bookManager,
                     MemberManager memberManager,
                     BorrowManager borrowManager
    ) {
        super(name);
        this.password = password;
        this.bookManager = bookManager;
        this.memberManager = memberManager;
        this.borrowManager = borrowManager;
    }

    public boolean checkPassword(String input) {
        return this.password.equals(input);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Book searchBook(long bookId) {
        Book book = bookManager.findById(bookId);
        if (book == null) {
            System.out.println("Book with id " + bookId + " not found.");
        }
        return book;
    }

    public void returnBook(long memberId, long bookId) {
        Reader reader = verifyMember(memberId);
        if (reader == null) return;

        Book book = searchBook(bookId);
        if (book == null) return;

        if (!borrowManager.getBorrowedBooks(memberId).contains(book)) {
            System.out.println("This book was not borrowed by this member.");
            return;
        }

        borrowManager.returnBook(reader, book);
        reader.getMemberRecord().refundBill();
        reader.getMemberRecord().decBooksIssued();
        System.out.println("Book returned successfully. 1 cash refunded to "
                + reader.getName() + ". Current cash: " + reader.getMemberRecord().getCash());
    }

    public Reader verifyMember(long id) {
        Reader reader = memberManager.findById(id);
        if (reader == null) {
            System.out.println("Member with id " + id + " not found in the system.");
            return null;
        }
        System.out.println("Member verified: " + reader.getName());
        return reader;
    }

    public void issueBook(long memberId, long bookId) {
        Reader reader = verifyMember(memberId);
        if (reader == null) return;

        if (reader.getMemberRecord().isMemberBorrow()) {
            System.out.println("Member has reached the book limit.");
            return;
        }

        Book book = searchBook(bookId);
        if (book == null) return;

        if (book.getStatus() == BookStatus.BORROWED) {
            System.out.println("Book is already borrowed.");
            return;
        }

        borrowManager.issueBook(reader, book);
        calculateBill(reader);
        System.out.println("Book issued successfully.");
    }

    public void calculateBill(Reader reader) {
        createBill(reader);
    }

    public void createBill(Reader reader) {
        reader.getMemberRecord().payBill();
        reader.getMemberRecord().incBooksIssued();
    }

    @Override
    public String whoYouAre() {
        return "I'm a librarian. My name is " + getName();
    }
}
