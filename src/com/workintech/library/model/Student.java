package com.workintech.library.model;

import com.workintech.library.enums.MemberType;

public class Student extends Reader {

    private MemberRecord memberRecord;
    private int studentNumber;

    public Student(String name,
                   long id,
                   String address,
                   String phoneNo,
                   int studentNumber
                   ) {
        super(name, id, MemberType.STUDENT, address, phoneNo);
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String whoYouAre() {
        return "I'm a student. My name is" + getName();
    }
}
