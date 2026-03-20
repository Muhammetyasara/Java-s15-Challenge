package com.workintech.library.enums;

public enum BookStatus {

    BORROWED("Borrowed"),
    AVAILABLE("Available");

    private final String status;

    BookStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
