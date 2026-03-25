package com.workintech.library.model;

import com.workintech.library.enums.MemberType;

public class Faculty extends Reader {

    private String department;

    public Faculty(String name,
                   long id,
                   String address,
                   String phoneNo,
                   String department
    ) {
        super(name, id, MemberType.FACULTY, address, phoneNo);
        this.setDepartment(department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String whoYouAre() {
        return "This is a faculty. Faculty name is " + getName() + ", department is " + getDepartment();
    }
}
