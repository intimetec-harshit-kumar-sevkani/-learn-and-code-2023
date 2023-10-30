package org.example.Service;

import org.example.Models.Entity;
import org.example.Validator.ValidateInteger;
import java.util.Scanner;

public class CarbonFootprintCalculator {

    public void CalculateCarbonFootprint()
    {
        CarbonFootprint carbonFootprint = new CarbonFootprint();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Email Address : ");
        String emailAddress = input.nextLine();

        int spam = ValidateInteger.validateNonNegativeIntegerInput(input, "Enter total emails in the spam folder: ");
        int mailWithAttachment = ValidateInteger.validateNonNegativeIntegerInput(input, "Enter total emails with attachment: ");
        int mailWithoutAttachment = ValidateInteger.validateNonNegativeIntegerInput(input, "Enter total emails without attachment: ");
        String serviceProvider = extractServiceProviderFromEmail(emailAddress);
        if (serviceProvider != null) {
            double totalCarbonFootprint = carbonFootprint.getCarbonFootprint(new Entity(emailAddress, serviceProvider, mailWithAttachment, mailWithoutAttachment, spam));
            System.out.println("Total Carbon Footprint  is  : " + totalCarbonFootprint + " g CO2e");
        } else {
            System.out.println("Invalid email format");
        }
    }

    public static String extractServiceProviderFromEmail(String emailAddress) {
        if (emailAddress != null && emailAddress.contains("@")) {
            String[] parts = emailAddress.split("@");
            if (parts.length == 2) {
                String domain = parts[1];
                int dotIndex = domain.indexOf('.');
                if (dotIndex != -1) {
                    return domain.substring(0, dotIndex);
                }
            }
        }
        return null;
    }
}
