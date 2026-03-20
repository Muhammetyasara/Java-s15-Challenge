package com.workintech.library.model;

public class Reader extends Person{

    public Reader(String name) {
        super(name);
    }

    @Override
    public String whoYouAre() {
        return "I'm a reader. My name is" + getName();
    }
}
