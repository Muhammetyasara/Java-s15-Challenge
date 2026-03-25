package com.workintech.library.manager;

import com.workintech.library.model.Book;
import com.workintech.library.model.Librarian;
import com.workintech.library.model.Reader;

public class Library {

    private BookManager bookManager;
    private MemberManager memberManager;
    private BorrowManager borrowManager;
    private Librarian librarian;

    public Library(String librarianName, String librarianPassword) {
        this.bookManager = new BookManager();
        this.memberManager = new MemberManager();
        this.borrowManager = new BorrowManager();
        this.librarian = new Librarian(librarianName, librarianPassword,
                bookManager, memberManager, borrowManager);
    }

    public void newBook(Book book) {
        bookManager.add(book);
        book.getAuthor().newBook(book);
    }

    public void lendBook(long memberId, long bookId) {
        librarian.issueBook(memberId, bookId);
    }

    public void takeBackBook(long memberId, long bookId) {
        librarian.returnBook(memberId, bookId);
    }

    public void showBook(long bookId) {
        Book book = bookManager.findById(bookId);
        if (book == null) {
            System.out.println("Invalid id.");
            return;
        }
        book.display();
    }

    public void getBooks() {
        bookManager.listAll();
    }

    public void getReaders() {
        memberManager.listAll();
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public MemberManager getMemberManager() {
        return memberManager;
    }

    public BorrowManager getBorrowManager() {
        return borrowManager;
    }
}