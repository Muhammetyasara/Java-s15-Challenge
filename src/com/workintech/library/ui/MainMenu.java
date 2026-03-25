package com.workintech.library.ui;

import com.workintech.library.manager.Library;
import com.workintech.library.util.InputHelper;

import java.util.Scanner;

public class MainMenu {

    private Scanner scanner;
    private Library library;


    public MainMenu(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }

    public void show() {
        while (true) {
            System.out.println("/---Library Management System---/");
            System.out.println("1-) Book Operations");
            System.out.println("2-) Member Operations");
            System.out.println("3-) Borrow Operations");
            System.out.println("0-) Exit");
            System.out.print("Choice: ");

            int choice = InputHelper.readInt(scanner);

            switch (choice) {
                case 1 -> new BookMenu(scanner, library).show();
                case 2 -> new MemberMenu(scanner, library).show();
                case 3 -> new BorrowMenu(scanner, library).show();
                case 0 -> {
                    System.out.println("Closing the system. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
