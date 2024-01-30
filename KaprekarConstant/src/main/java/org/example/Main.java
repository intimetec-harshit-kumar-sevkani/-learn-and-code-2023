package org.example;

import org.example.Service.KaprekarConstantProcessor;
import org.example.Utils.UserInputHandler;
import org.example.Validator.ValidateUserInput;

public class Main {

    public static void main(String[] args) {
        int userInput = UserInputHandler.getUserInput();
        if (ValidateUserInput.isValidNumber(userInput)) {
            KaprekarConstantProcessor.findKaprekarSolution(userInput);
        } else {
            System.out.println("number is not valid");
        }
    }
}












