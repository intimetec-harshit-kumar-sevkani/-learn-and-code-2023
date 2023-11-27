package org.example.Service;

import org.example.Models.Email;

import static org.example.Constants.CarbonFootprintConstants.*;

public class CarbonFootprint {
    public static double getCarbonFootprint(Email email) {
            double inboxCount = email.getInboxCount();
            double sentCount = email.getSentCount();
            double spamCount = email.getSpamCount();
            double totalCarbonFootprint = ((inboxCount * INBOX_EMAIL_CARBON_EQUIVALENT) + (sentCount * SENT_EMAIL_CARBON_EQUIVALENT) + (spamCount * SPAM_EMAIL_CARBON_EQUIVALENT)) * GMAIL_CARBON_INTENSITY;
            return totalCarbonFootprint;
    }

}
