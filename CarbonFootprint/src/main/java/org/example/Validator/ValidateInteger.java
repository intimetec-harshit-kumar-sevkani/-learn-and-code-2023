package org.example.Validator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateInteger {
    public static int validateNonNegativeIntegerInput(Scanner input, String prompt) {
        int value = -1;
        while (value < 0) {
            try {
                System.out.print(prompt);
                value = input.nextInt();
                if (value < 0) {
                    System.out.println("Please enter a non-negative integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                input.nextLine();
            }
        }
        return value;
    }
}
