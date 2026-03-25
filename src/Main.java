import com.workintech.library.manager.Library;
import com.workintech.library.ui.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library System");
        System.out.print("Enter librarian name: ");
        String name = scanner.nextLine();
        System.out.print("Enter librarian password: ");
        String password = scanner.nextLine();

        Library library = new Library(name, password);

        System.out.print("Verify password: ");
        String input = scanner.nextLine();

        int attempts = 3;

        while (attempts > 0) {
            if (library.getLibrarian().checkPassword(input)) {
                System.out.println("Access granted. Welcome " + library.getLibrarian().getName());
                new MainMenu(scanner, library).show();
                break;
            } else {
                attempts--;
                if (attempts == 0) {
                    System.out.println("Too many failed attempts. Exiting...");
                    break;
                }
                System.out.println("Wrong password. " + attempts + " attempts left. Try again: ");
                input = scanner.nextLine();
            }
        }

        scanner.close();
    }
}