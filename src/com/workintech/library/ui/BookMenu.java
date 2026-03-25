package com.workintech.library.ui;

import com.workintech.library.enums.BookCategory;
import com.workintech.library.enums.BookStatus;
import com.workintech.library.manager.Library;
import com.workintech.library.model.*;
import com.workintech.library.util.InputHelper;

import java.util.List;
import java.util.Scanner;

public class BookMenu {

    private Scanner scanner;
    private Library library;


    public BookMenu(Scanner scanner, Library library) {
        this.scanner = scanner;
        this.library = library;
    }

    public void show() {
        while (true) {
            System.out.println("/--Book Operations--/");
            System.out.println("1-) Add book");
            System.out.println("2-) Remove book");
            System.out.println("3-) Find book by id");
            System.out.println("4-) Find books by author");
            System.out.println("5-) Find books by category");
            System.out.println("6-) List all");
            System.out.println("0-) Back to the Main Menu");
            System.out.print("Choice: ");

            int choice = InputHelper.readInt(scanner);

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> findById();
                case 4 -> findByAuthor();
                case 5 -> findByCategory();
                case 6 -> library.getBooks();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void addBook() {
        System.out.print("Author name: ");
        String authorName = scanner.nextLine();
        Author author = new Author(authorName);

        System.out.print("Book ID: ");
        long id = InputHelper.readLong(scanner);
        if (InputHelper.isBookExist(id, library)) {
            System.out.println("Book with id: " + id + " already exist. Please enter different id.");
            return;
        }


        System.out.print("Book name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = InputHelper.readDouble(scanner);

        System.out.print("Edition: ");
        String edition = scanner.nextLine();

        System.out.println("""
                Category:\s
                1-) Study Book\s
                2-) Journal\s
                3-) Magazine""");
        int categoryChoice = InputHelper.readInt(scanner);

        Book book = switch (categoryChoice) {
            case 1 -> {
                System.out.print("Subject: ");
                String subject = scanner.nextLine();
                yield new StudyBook(id, author, name, price, BookStatus.AVAILABLE, edition, subject);
            }
            case 2 -> {
                System.out.print("Research area: ");
                String researchArea = scanner.nextLine();
                yield new Journal(id, author, name, price, BookStatus.AVAILABLE, edition, researchArea);
            }
            case 3 -> {
                System.out.print("Publish month: ");
                String publishMonth = scanner.nextLine();
                yield new Magazine(id, author, name, price, BookStatus.AVAILABLE, edition, publishMonth);
            }
            default -> null;
        };

        if (book == null) {
            System.out.println("Invalid category");
            return;
        }

        library.newBook(book);
        book.display();
        System.out.println("Book added successfully.");

    }

    private void removeBook() {
        System.out.print("Enter book id: ");
        long id = InputHelper.readLong(scanner);
        library.getBookManager().remove(id);
        System.out.println("Book removed successfully");
    }

    private void findById() {
        System.out.print("Enter book id: ");
        long id = InputHelper.readLong(scanner);
        library.showBook(id);
    }

    private void findByAuthor() {
        System.out.print("Enter author name: ");
        String name = scanner.nextLine();
        List<Book> books = library.getBookManager().findByAuthor(name);

        if (books.isEmpty()) {
            System.out.println("No books found for this author.");
            return;
        }
        for (Book book : books) {
            book.display();
        }
    }

    private void findByCategory() {
        System.out.println("""
                Category:\s
                1-) Study Book\s
                2-) Journal\s
                3-) Magazine""");
        int choice = InputHelper.readInt(scanner);

        BookCategory category = switch (choice) {
            case 1 -> BookCategory.STUDYBOOK;
            case 2 -> BookCategory.JOURNAL;
            case 3 -> BookCategory.MAGAZINE;
            default -> null;
        };

        if (category == null) {
            System.out.println("Invalid category.");
            return;
        }

        List<Book> books = library.getBookManager().findByCategory(category);
        if (books.isEmpty()) {
            System.out.println("No books found for this category.");
            return;
        }
        for (Book book : books) {
            book.display();
        }
    }
}
