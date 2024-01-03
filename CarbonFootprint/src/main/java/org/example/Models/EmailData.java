package org.example.Models;

public class EmailData {
    private int inboxCount;
    private int sentCount;
    private int spamCount;
    public EmailData() {
    }

    public EmailData(int inboxCount, int sentCount, int spamCount) {
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
