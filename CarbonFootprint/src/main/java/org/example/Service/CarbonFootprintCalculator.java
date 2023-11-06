package org.example.Service;

import org.example.Models.Entity;
import org.example.Validator.ValidateNumber;
import java.util.Scanner;

public class CarbonFootprintCalculator {

    public void CalculateCarbonFootprint()
    {
        CarbonFootprint carbonFootprint = new CarbonFootprint();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Email Address : ");
        String emailAddress = scanner.nextLine();

        int spamCount = ValidateNumber.readNonNegativeNumber(scanner, "Enter total emails in the spam folder: ");
        int inboxCount = ValidateNumber.readNonNegativeNumber(scanner, "Enter total emails with attachment: ");
        int sentCount = ValidateNumber.readNonNegativeNumber(scanner, "Enter total emails without attachment: ");
        String serviceProvider = extractServiceProviderFromEmail(emailAddress);
        if (serviceProvider != null) {
            double totalCarbonFootprint = carbonFootprint.getCarbonFootprint(new Entity(emailAddress, serviceProvider, inboxCount, sentCount, spamCount));
            System.out.println("Total Carbon Footprint  is  : " + totalCarbonFootprint + " g CO2e");
        } else {
            System.out.println("Invalid email format");
        }
    }

    public static String extractServiceProviderFromEmail(String emailAddress) {
        if (emailAddress != null && emailAddress.contains("@")) {
            String[] emailComponents = emailAddress.split("@");
            if (emailComponents.length == 2) {
                String domain = emailComponents[1];
                int dotIndex = domain.indexOf('.');
                if (dotIndex != -1) {
                    return domain.substring(0, dotIndex);
                }
            }
        }
        return null;
    }
}
