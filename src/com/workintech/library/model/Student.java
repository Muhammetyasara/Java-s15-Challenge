package com.workintech.library.model;

public class Student extends Reader{

    public Student(String name) {
        super(name);
    }

    @Override
    public String whoYouAre(){
        return "I'm a student. My name is" + getName();
    }
}
