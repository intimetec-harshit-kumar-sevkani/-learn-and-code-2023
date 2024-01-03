package org.example.Service;

import org.example.Models.EmailCredential;

import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class EmailConnectionManager {
    public static Store getConnection(EmailCredential emailCredential) {
        try {
            Properties properties = getEmailProperties();
            Session session = Session.getDefaultInstance(properties, null);
            Store connection = session.getStore("imaps");
            connection.connect("imap.gmail.com", emailCredential.getEmailAddress(), emailCredential.getPassword());
            return connection;
        } catch (Exception ex) {
            System.out.println("Exception : " + ex);
            return null;
        }
    }

    public static Properties getEmailProperties() {
        Properties properties = new Properties();
        setEmailProperties(properties);
        return properties;
    }
    public static void setEmailProperties(Properties properties){
        properties.setProperty("mail.connection.protocol", "imaps");
        properties.setProperty("mail.imap.host", "imap.example.com");
        properties.setProperty("mail.imap.port", "993");
        properties.put("mail.imaps.ssl.protocols", "TLSv1.2");
        properties.put("mail.imaps.ssl.ciphersuites", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
    }

}

