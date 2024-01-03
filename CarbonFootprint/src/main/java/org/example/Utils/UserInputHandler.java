package org.example.Utils;

import org.example.Models.EmailCredential;

import java.util.Scanner;

public class UserInputHandler {
    public static EmailCredential getUserCredentials() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Email Address: ");
            String emailAddress = scanner.nextLine();
            System.out.print("Enter the password: ");
            String password = scanner.nextLine();

            return new EmailCredential(emailAddress, password);
    }
}


