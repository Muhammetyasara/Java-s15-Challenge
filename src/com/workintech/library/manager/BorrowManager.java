package com.workintech.library.manager;

import com.workintech.library.enums.BookStatus;
import com.workintech.library.model.Book;
import com.workintech.library.model.Reader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BorrowManager {

    private Map<Long, Set<Book>> borrowedBooks = new HashMap<>();

    public void issueBook(Reader reader, Book book) {
        long memberId = reader.getMemberRecord().getId();
        borrowedBooks.putIfAbsent(memberId, new HashSet<>());
        borrowedBooks.get(memberId).add(book);
        book.setStatus(BookStatus.BORROWED);
    }

    public void returnBook(Reader reader, Book book) {
        long memberId = reader.getMemberRecord().getId();
        if (borrowedBooks.containsKey(memberId)) {
            borrowedBooks.get(memberId).remove(book);
            book.setStatus(BookStatus.AVAILABLE);
        } else {
            System.out.println("No borrowed books found for this member.");
        }
    }

    public Set<Book> getBorrowedBooks(long memberId){
        return borrowedBooks.getOrDefault(memberId, new HashSet<>());
    }
}
