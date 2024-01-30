package org.example.Utils;

import java.util.Scanner;

public class UserInputHandler {

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        System.out.println("Enter the number of 4 digits : ");
        inputNumber = scanner.nextInt();
        return inputNumber;
    }
}
