package org.example.Service;

import org.example.Models.EmailCredential;
import org.example.Models.EmailData;
import org.example.Utils.UserInputHandler;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

public class CarbonFootprintCalculator {
    private static final String SENT_MAIL_FOLDER = "[Gmail]/Sent Mail";
    private static final String INBOX_MAIL_FOLDER = "inbox";
    private static final String SPAM_MAIL_FOLDER = "[Gmail]/Spam";
    public void calculateCarbonFootprint() throws MessagingException {
        try {
            EmailCredential credential = UserInputHandler.getUserCredentials();
            Store connection = EmailConnectionManager.getConnection(credential);
            if (connection != null) {
                EmailData emailData = getEmailData(connection);
                CarbonFootprint carbonFootprint = new CarbonFootprint();
                double totalCarbonFootprint = carbonFootprint.getCarbonFootprint(emailData);
                System.out.println("total carbon footprint " + totalCarbonFootprint);
                connection.close();
            }
        } catch (Exception ex) {
            System.out.println("Connection could not be established." + ex);
        }
    }
    private EmailData getEmailData(Store connection) throws MessagingException {
        int inboxEmailCount = getFolderEmailCount(connection, INBOX_MAIL_FOLDER);
        int spamEmailCount = getFolderEmailCount(connection, SPAM_MAIL_FOLDER);
        int sentEmailCount = getFolderEmailCount(connection, SENT_MAIL_FOLDER);
        return new EmailData(inboxEmailCount, sentEmailCount, spamEmailCount);
    }
    private static int getFolderEmailCount(Store connection, String folderName) throws MessagingException {
        Folder folder = connection.getFolder(folderName);
        folder.open(Folder.READ_ONLY);
        int messageCount = folder.getMessageCount();
        folder.close(true);
        return messageCount;
    }
}
