package com.workintech.library.model;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.enums.BookStatus;

import java.time.LocalDate;

public class Journal extends Book {

    private String researchArea;

    public Journal(long id,
                   Author author,
                   String name,
                   double price,
                   BookStatus status,
                   String edition,
                   String researchArea
    ) {
        super(id, author, name, price, status, edition, BookCategory.JOURNAL);
        this.researchArea = researchArea;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        this.researchArea = researchArea;
    }

    @Override
    public void display() {
        System.out.println("'" + getName() + "' is a journal written by " + getAuthor().getName()
                + ". It focuses on " + researchArea
                + ". Edition: " + getEdition()
                + ". Price: " + getPrice() + " TL. Status: " + getStatus());
    }
}
