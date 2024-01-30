package org.example.Service;

import org.example.Constant.Constants;

import java.util.Arrays;

public class KaprekarConstantProcessor {
    public static void findKaprekarSolution(int number) {
        int currentIteration = 0;
        while (number != Constants.KAPREKAR_CONSTANT && currentIteration <= 7) {
            currentIteration++;
            int[] digits = extractDigits(number);
            int descendingOrder = convertIntoDescendingOrder(digits);
            int ascendingOrder = convertIntoAscendingOrder(digits);
            number = calculateNextNumber(descendingOrder, ascendingOrder);
            printIterationDetails(currentIteration, descendingOrder, ascendingOrder, number);
        }
    }

    private static int[] extractDigits(int number) {
        int[] digits = new int[Constants.NUMBER_LENGTH];
        for (int digitIndex = 0; digitIndex < Constants.NUMBER_LENGTH; digitIndex++) {
            digits[digitIndex] = number % 10;
            number /= 10;
        }
        return digits;
    }

    private static int convertIntoDescendingOrder(int[] digits) {
        int descendingOrder = 0;
        Arrays.sort(digits);
        for (int sortedIndex = 0; sortedIndex < Constants.NUMBER_LENGTH; sortedIndex++) {
            descendingOrder = descendingOrder * 10 + digits[3 - sortedIndex];
        }
        return descendingOrder;
    }

    private static int convertIntoAscendingOrder(int[] digits) {
        int ascendingOrder = 0;
        for (int sortedIndex = 0; sortedIndex < Constants.NUMBER_LENGTH; sortedIndex++) {
            ascendingOrder = ascendingOrder * 10 + digits[sortedIndex];
        }
        return ascendingOrder;
    }

    private static int calculateNextNumber(int descendingOrder, int ascendingOrder) {
        return descendingOrder - ascendingOrder;
    }

    private static void printIterationDetails(int iteration, int descendingOrder, int ascendingOrder, int result) {
        System.out.println("Iteration " + iteration + " : " + descendingOrder + " - " + ascendingOrder + " = " + result);
    }
}
