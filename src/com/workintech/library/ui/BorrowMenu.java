package com.workintech.library.ui;

import com.workintech.library.manager.Library;
import com.workintech.library.model.Book;
import com.workintech.library.util.InputHelper;

import java.util.Scanner;
import java.util.Set;

public class BorrowMenu {

    private Scanner scanner;
    private Library library;


    public BorrowMenu(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }

    public void show() {
        while (true) {
            System.out.println("/--Book Operations--/");
            System.out.println("1-) Borrow book");
            System.out.println("2-) Return book");
            System.out.println("3-) Show borrowed books of member");
            System.out.println("0-) Back");
            System.out.print("Choice: ");

            int choice = InputHelper.readInt(scanner);

            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showBorrowedBooks();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void borrowBook() {
        System.out.print("Enter member ID: ");
        long memberId = InputHelper.readLong(scanner);

        System.out.print("Enter book ID: ");
        long bookId = InputHelper.readLong(scanner);

        library.lendBook(memberId, bookId);
    }

    private void returnBook() {
        System.out.print("Enter member ID: ");
        long memberId = InputHelper.readLong(scanner);

        System.out.print("Enter book ID: ");
        long bookId = InputHelper.readLong(scanner);

        library.takeBackBook(memberId, bookId);
    }

    private void showBorrowedBooks() {
        System.out.print("Enter member ID: ");
        long memberId = InputHelper.readLong(scanner);

        Set<Book> borrowedBooks = library.getBorrowManager().getBorrowedBooks(memberId);

        if (borrowedBooks.isEmpty()) {
            System.out.println("This member has no borrowed books.");
            return;
        }

        borrowedBooks.forEach(Book::display);
    }
}
