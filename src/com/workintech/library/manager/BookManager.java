package com.workintech.library.manager;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class BookManager implements IManageable<Book> {

    private Map<Long, Book> books = new HashMap<>();

    @Override
    public void add(Book book) {
        if (!books.containsKey(book.getId()))
            books.put(book.getId(), book);
    }

    @Override
    public void remove(long id) {
        books.remove(id);
    }

    @Override
    public Book findById(long id) {
        return books.get(id);
    }

    public List<Book> findByAuthor(String authorName) {
        return books.values().stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
    }

    public List<Book> findByCategory(BookCategory bookCategory) {
        return books.values().stream().filter(book -> book.getBookCategory() == bookCategory)
                .collect(Collectors.toList());
    }

    @Override
    public void listAll() {
        if (books.isEmpty()) {
            System.out.println("No books in the system");
            return;
        }

        books.values().forEach(Book::display);
    }
}
