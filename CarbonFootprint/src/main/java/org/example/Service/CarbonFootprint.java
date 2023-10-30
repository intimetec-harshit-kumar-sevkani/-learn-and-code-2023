package org.example.Service;

import org.example.Models.Entity;
import static org.example.Constants.CarbonFootprintConstants.*;

public class CarbonFootprint {
    public static double getCarbonFootprint(Entity entity) {
            String emailId = entity.getEmail();
            String source = entity.getSource();
            double mailWithAttachment = entity.getMailWithAttachment();
            double mailWithoutAttachment = entity.getMailWithoutAttachment();
            double spam = entity.getSpam();
            double emailSize = (mailWithAttachment * MAILWITHATTACHMENT_CARBON_EQUIVALENT ) + (mailWithoutAttachment * MAILWITHOUTATTACHMENT_CARBON_EQUIVALENT) + (spam * SPAM_CARBON_EQUIVALENT );
            double carbonFootprint = emailSize * getCarbonIntensity(source);
            return carbonFootprint;
    }
    private static double getCarbonIntensity(String source) {
        switch (source) {
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
