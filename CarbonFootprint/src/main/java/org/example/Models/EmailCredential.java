package org.example.Models;

public class EmailCredential {

    private final String emailAddress;
    private final String password;

    public EmailCredential(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}

