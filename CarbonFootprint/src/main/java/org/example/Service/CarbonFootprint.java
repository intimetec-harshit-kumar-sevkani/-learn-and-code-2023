package org.example.Service;

import org.example.Models.Entity;
import static org.example.Constants.CarbonFootprintConstants.*;

public class CarbonFootprint {
    public static double getCarbonFootprint(Entity entity) {
            String emailId = entity.getEmail();
            String serviceProvider = entity.getServiceProvider();
            double inboxCount = entity.getInboxCount();
            double sentCount = entity.getSentCount();
            double spamCount = entity.getSpamCount();
            double totalCarbonEquivalent = (inboxCount * INBOX_EMAIL_CARBON_EQUIVALENT) + (sentCount * SENT_EMAIL_CARBON_EQUIVALENT) + (spamCount * SPAM_EMAIL_CARBON_EQUIVALENT);
            double totalCarbonFootprint = totalCarbonEquivalent * getCarbonIntensity(serviceProvider);
            return totalCarbonFootprint;
    }
    private static double getCarbonIntensity(String serviceProvider) {
        switch (serviceProvider) {
            case "gmail":
                return GMAIL_CARBON_INTENSITY;
            case "outlook":
                return OUTLOOK_CARBON_INTENSITY;
            case "yahoo":
                return YAHOO_CARBON_INTENSITY;
            default:
                return 0.5;
        }
    }
}
