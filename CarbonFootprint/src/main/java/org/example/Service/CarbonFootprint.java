package org.example.Service;

import org.example.Models.EmailData;
import static org.example.Constants.CarbonFootprintConstants.*;

public class CarbonFootprint {
    public static double getCarbonFootprint(EmailData emailData) {
            double inboxCount = emailData.getInboxCount();
            double sentCount = emailData.getSentCount();
            double spamCount = emailData.getSpamCount();
            double totalCarbonFootprint = ((inboxCount * INBOX_EMAIL_CARBON_EQUIVALENT) + (sentCount * SENT_EMAIL_CARBON_EQUIVALENT) + (spamCount * SPAM_EMAIL_CARBON_EQUIVALENT)) * GMAIL_CARBON_INTENSITY;
            return totalCarbonFootprint;
    }

}
