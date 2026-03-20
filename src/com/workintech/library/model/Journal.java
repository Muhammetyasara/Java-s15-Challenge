package com.workintech.library.model;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.enums.BookStatus;

import java.time.LocalDate;

public class Journal extends Book {
    public Journal(long id,
                   Author author,
                   String name,
                   double price,
                   BookStatus status,
                   String edition,
                   LocalDate purchaseDate,
                   Person owner) {
        super(id, author, name, price, status, edition, purchaseDate, owner, BookCategory.JOURNAL);
    }
}
