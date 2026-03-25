package com.workintech.library.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {

    private List<Book> books = new ArrayList<>();

    public Author(String name) {
        super(name);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void newBook(Book book) {
        if (book.getAuthor().getName().equalsIgnoreCase(getName()))
            books.add(book);
    }

    @Override
    public String whoYouAre() {
        return "I'm an author. My name is " + getName();
    }
}