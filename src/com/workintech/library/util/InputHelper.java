package com.workintech.library.util;

import com.workintech.library.manager.Library;

import java.util.Scanner;

public class InputHelper {

    public static int readInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    public static long readLong(Scanner scanner) {
        while (true) {
            try {
                return Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    public static double readDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    public static boolean isMemberExist(long memberId, Library library) {
        return library.getMemberManager().findById(memberId) != null;
    }

    public static boolean isBookExist(long bookId, Library library) {
        return library.getBookManager().findById(bookId) != null;
    }
}
