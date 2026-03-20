package com.workintech.library.model;

public class Author extends Person{

    public Author(String name) {
        super(name);
    }

    @Override
    public String whoYouAre() {
        return "I'm an author. My name is" + getName();
    }
}
