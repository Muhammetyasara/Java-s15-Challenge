package com.workintech.library.model;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.enums.BookStatus;

import java.time.LocalDate;

public class StudyBook extends Book {
    public StudyBook(long id,
                     Author author,
                     String name,
                     double price,
                     BookStatus status,
                     String edition,
                     LocalDate purchaseDate,
                     Person owner) {
        super(id, author, name, price, status, edition, purchaseDate, owner, BookCategory.STUDYBOOK);
    }
}
