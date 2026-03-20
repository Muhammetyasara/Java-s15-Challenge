package com.workintech.library.model;

public class Librarian extends Person{

    public Librarian(String name) {
        super(name);
    }

    @Override
    public String whoYouAre() {
        return "I'm a librarian. My name is" + getName();
    }
}
