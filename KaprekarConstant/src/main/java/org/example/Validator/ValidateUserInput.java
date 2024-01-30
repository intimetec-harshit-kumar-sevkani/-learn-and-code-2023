package org.example.Validator;

public class ValidateUserInput {
    public static boolean isValidNumber(int number) {
        if (!isWithinValidRange(number)) {
            return false;
        }
        int uniqueDigitCount = countUniqueDigits(number);
        return hasAtLeastTwoUniqueDigits(uniqueDigitCount);
    }

    private static boolean isWithinValidRange(int number) {
        return number >= 0 && number <= 9999;
    }

    private static int countUniqueDigits(int number) {
        int uniqueDigitCount = 0;
        int[] digitCount = new int[10];
        while (number > 0) {
            int digit = number % 10;
            digitCount[digit]++;
            if (digitCount[digit] == 1) {
                uniqueDigitCount++;
            }
            number = number / 10;
        }
        return uniqueDigitCount;
    }

    private static boolean hasAtLeastTwoUniqueDigits(int uniqueDigitCount) {
        return uniqueDigitCount >= 2;
    }
}
