package com.workintech.library.manager;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.model.Book;

import java.util.*;

public class BookManager {

    private Map<Long, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (!books.containsKey(book.getId()))
            books.put(book.getId(), book);
    }

    public void removeBook(Book book) {
        books.remove(book.getId());
    }

    public Book findById(long id){
        return books.get(id);
    }

    public void updateBook(Book book){
        books.put(book.getId(), book);
    }

    public List<Book> findByAuthor(String authorName){
        List<Book> result = new ArrayList<>();
        for (Book book: books.values()){
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)){
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findByCategory(BookCategory bookCategory){
        List<Book> result = new ArrayList<>();
        for (Book book: books.values()){
            if (book.getBookCategory() == bookCategory){
                result.add(book);
            }
        }

        return result;
    }

    public void listAll(){
        if (books.isEmpty()){
            System.out.println("No books in the system");
            return;
        }

        for (Book book: books.values()){
            book.display();
        }
    }
}
