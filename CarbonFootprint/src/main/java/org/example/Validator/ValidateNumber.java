package org.example.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateNumber {

    public static int readNonNegativeNumber(Scanner scanner, String prompt) {
        int input;
        do {
            System.out.print(prompt);
            input = readNumber(scanner);
            if (input < 0) {
                System.out.println("Please enter a non-negative integer.");
            }
        } while (input < 0);
        return input;
    }

    public static int readNumber(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            input.nextLine();
            return -1;
        }
    }

}
