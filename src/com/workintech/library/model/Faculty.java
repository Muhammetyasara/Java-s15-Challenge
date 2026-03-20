package com.workintech.library.model;

public class Faculty extends Reader{

    public Faculty(String name) {
        super(name);
    }

    @Override
    public String whoYouAre(){
        return "I'm a faculty. My name is" + getName();
    }
}
