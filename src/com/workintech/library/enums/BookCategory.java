package com.workintech.library.enums;

public enum BookCategory {

    JOURNAL("Journal"),
    STUDYBOOK("Study Book"),
    MAGAZINE("Magazine");

    private final String category;

    BookCategory(String category) {
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
}
