package org.example;
import java.sql.SQLOutput;
import java.util.*;

class KaprekarConstant{
    public static final int KAPREKAR_CONSTANT = 6174;
    public static boolean isValidNumber(int number) {
        if (number < 0 || number > 9999) {
            return false;
        }
        int uniqueDigitCount = 0;
        int digitCount[] = new int[10];
        while (number > 0) {
            int digit = number % 10;
            digitCount[digit]++;
            if (digitCount[digit] == 1) {
                uniqueDigitCount++;
                if (uniqueDigitCount >= 2) {
                    return true;
                }
            }
            number = number / 10;
        }
        return false;
    }

    public static boolean findKaprekarConstant(int number) {
        int iteration = 0 ;
        while (number != KAPREKAR_CONSTANT && iteration <= 7 ) {
            iteration++;
            int digits[] = new int[4];
            for (int index = 0; index < 4; index++) {
                digits[index] = number % 10;
                number /= 10;
            }
            int ascending = 0;
            int descending = 0;
            Arrays.sort(digits);
            for (int index = 0; index < 4; index++) {
                descending = descending * 10 + digits[3 - index];
                ascending = ascending * 10 + digits[index];
            }
            number = descending - ascending;
            System.out.println("Iteration " + iteration + " : " + descending + " - " + ascending + " = " + number);
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        System.out.println("Enter the number of 4 digits : ");

        inputNumber = scanner.nextInt();
        if(KaprekarConstant.isValidNumber(inputNumber)) {
            while (!KaprekarConstant.findKaprekarConstant(inputNumber)) ;
        }
        else{
            System.out.println("number is not valid");
        }
    }
}









