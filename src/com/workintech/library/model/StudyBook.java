package com.workintech.library.model;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.enums.BookStatus;

import java.time.LocalDate;

public class StudyBook extends Book {

    private String subject;

    public StudyBook(long id,
                     Author author,
                     String name,
                     double price,
                     BookStatus status,
                     String edition,
                     String subject
    ) {
        super(id, author, name, price, status, edition, BookCategory.STUDYBOOK);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void display() {
        System.out.println("'" + getName() + "' is a study book written by " + getAuthor().getName()
                + ". It covers the subject of " + subject
                + ". Edition: " + getEdition()
                + ". Price: " + getPrice() + " TL. Status: " + getStatus());
    }
}
