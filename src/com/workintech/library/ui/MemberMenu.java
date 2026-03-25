package com.workintech.library.ui;

import com.workintech.library.manager.Library;
import com.workintech.library.model.Faculty;
import com.workintech.library.model.Reader;
import com.workintech.library.model.Student;
import com.workintech.library.util.InputHelper;

import java.util.Scanner;

public class MemberMenu {

    private Scanner scanner;
    private Library library;


    public MemberMenu(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }

    public void show() {
        while (true) {
            System.out.println("/--Member Opeartions--/");
            System.out.println("1-) Add student");
            System.out.println("2-) Add faculty");
            System.out.println("3-) Remove member");
            System.out.println("4-) Find member by id");
            System.out.println("5-) List all members");
            System.out.println("0-) Back");
            System.out.print("Choice: ");

            int choice = InputHelper.readInt(scanner);

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addFaculty();
                case 3 -> removeMember();
                case 4 -> findById();
                case 5 -> library.getReaders();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");

            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        long id = InputHelper.readLong(scanner);
        if (InputHelper.isMemberExist(id, library)) {
            System.out.println("Member with id: " + id + " already exist. Please enter different id.");
            return;
        }

        System.out.print("Enter student address: ");
        String address = scanner.nextLine();

        System.out.print("Enter student phone number: ");
        String phoneNo = scanner.nextLine();

        System.out.print("Enter student number: ");
        int studentNumber = InputHelper.readInt(scanner);

        library.getMemberManager().add(new Student(name, id, address, phoneNo, studentNumber));
    }

    private void addFaculty() {
        System.out.print("Enter faculty name: ");
        String name = scanner.nextLine();

        System.out.print("Enter faculty ID: ");
        long id = InputHelper.readLong(scanner);
        if (InputHelper.isMemberExist(id, library)) {
            System.out.println("Member with id: " + id + " already exist. Please enter different id.");
            return;
        }

        System.out.print("Enter faculty address: ");
        String address = scanner.nextLine();

        System.out.print("Enter faculty phone number: ");
        String phoneNo = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        library.getMemberManager().add(new Faculty(name, id, address, phoneNo, department));
        System.out.println("Faculty added successfully");
    }

    private void removeMember() {
        System.out.print("Enter member ID: ");
        long id = InputHelper.readLong(scanner);
        if (library.getMemberManager().findById(id) == null) {
            System.out.println("Invalid ID");
            return;
        }
        library.getMemberManager().remove(id);
        System.out.println("Member removed successfully");
    }

    private void findById() {
        System.out.print("Enter member ID: ");
        long id = InputHelper.readLong(scanner);
        Reader reader = library.getMemberManager().findById(id);
        if (reader != null) {
            System.out.println(reader.whoYouAre());
        } else {
            System.out.println("There is no member with id: " + id);
        }
    }
}
