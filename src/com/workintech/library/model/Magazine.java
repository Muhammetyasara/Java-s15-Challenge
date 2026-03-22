package com.workintech.library.model;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.enums.BookStatus;

import java.time.LocalDate;

public class Magazine extends Book {

    private String publishMonth;

    public Magazine(long id,
                    Author author,
                    String name,
                    double price,
                    BookStatus status,
                    String edition,
                    String publishMonth
    ) {
        super(id, author, name, price, status, edition, BookCategory.MAGAZINE);
        this.publishMonth = publishMonth;
    }

    public String getPublishMonth() {
        return publishMonth;
    }

    public void setPublishMonth(String publishMonth) {
        this.publishMonth = publishMonth;
    }

    @Override
    public void display() {
        System.out.println("'" + getName() + "' is a magazine published in " + publishMonth
                + ", written by " + getAuthor().getName()
                + ". Edition: " + getEdition()
                + ". Price: " + getPrice() + " TL. Status: " + getStatus());
    }
}
