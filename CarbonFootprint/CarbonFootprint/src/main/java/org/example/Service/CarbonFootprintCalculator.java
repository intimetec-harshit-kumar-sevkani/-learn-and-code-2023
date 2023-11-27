package org.example.Service;

import org.example.Models.Email;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;
import java.util.Scanner;


public class CarbonFootprintCalculator {
    private static final String SENT_MAIL_FOLDER = "[Gmail]/Sent Mail";
    private static final String INBOX_MAIL_FOLDER = "inbox";
    private static final String SPAM_MAIL_FOLDER = "[Gmail]/Spam";
    public Store getConnection(String emailAddress, String password)
    {
        try {
              Properties properties = new Properties();
              properties.setProperty("mail.connection.protocol", "imaps");
              properties.setProperty("mail.imap.host", "imap.example.com");
              properties.setProperty("mail.imap.port", "993");
              properties.put("mail.imaps.ssl.protocols", "TLSv1.2");
              properties.put("mail.imaps.ssl.ciphersuites", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
              Session session = Session.getDefaultInstance(properties, null);

              Store connection = session.getStore("imaps");
              connection.connect("smtp.gmail.com", emailAddress, password);
              return connection;
           }
        catch (Exception ex)
        {
              System.out.println("exception : " + ex);
        }
        return null;
    }

    public void calculateCarbonFootprint() throws MessagingException {
        CarbonFootprint carbonFootprint = new CarbonFootprint();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Email Address : ");
        String emailAddress = scanner.nextLine();
        System.out.print("Enter the password :  ");
        String password = scanner.nextLine();

        try {
              Store connection = getConnection(emailAddress, password);
              if(connection != null) {
                int inboxEmailCount = getFolderEmailCount(connection, INBOX_MAIL_FOLDER);
                int spamEmailCount = getFolderEmailCount(connection, SPAM_MAIL_FOLDER);
                int sentEmailCount = getFolderEmailCount(connection, SENT_MAIL_FOLDER);

                double totalCarbonFootprint = carbonFootprint.getCarbonFootprint(new Email(inboxEmailCount, sentEmailCount, spamEmailCount));

                System.out.println("Total Carbon Footprint  is  : " + totalCarbonFootprint + " g CO2e");

                connection.close();
              }
            else{
                System.out.println("Connection could not be established.");
            }
        }
        catch (Exception ex)
        {
            System.out.println("exception : " + ex);
        }
    }

    private static int getFolderEmailCount(Store connection, String folderName) throws MessagingException {
        Folder folder = connection.getFolder(folderName);
        folder.open(Folder.READ_ONLY);
        int messageCount = folder.getMessageCount();
        folder.close(true);
        return messageCount;
    }

}
