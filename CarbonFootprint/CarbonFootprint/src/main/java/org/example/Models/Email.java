package org.example.Models;

public class Email {
    private int inboxCount;
    private int sentCount;
    private int spamCount;
    public Email() {
    }

    public Email(int inboxCount, int sentCount, int spamCount) {
        this.inboxCount = inboxCount;
        this.sentCount = sentCount;
        this.spamCount = spamCount;
    }
    public int getInboxCount() {
        return inboxCount;
    }
    public int getSentCount() {
        return sentCount;
    }
    public int getSpamCount() {
        return spamCount;
    }

}
