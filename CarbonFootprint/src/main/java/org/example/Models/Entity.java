package org.example.Models;

public class Entity {
    private String email;
    private String serviceProvider;
    private int inboxCount;
    private int sentCount;
    private int spamCount;

    public Entity() {
    }

    public Entity(String email, String serviceProvider, int inboxCount, int sentCount, int spamCount) {
        this.email = email;
        this.serviceProvider = serviceProvider;
        this.inboxCount = inboxCount;
        this.sentCount = sentCount;
        this.spamCount = spamCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public int getInboxCount() {
        return inboxCount;
    }

    public void setInboxCount(int inboxCount) {
        this.inboxCount = inboxCount;
    }

    public int getSentCount() {
        return sentCount;
    }

    public void setSentCount(int sentCount) {
        this.sentCount = sentCount;
    }

    public int getSpamCount() {
        return spamCount;
    }

    public void setSpamCount(int spamCount) {
        this.spamCount = spamCount;
    }
}
