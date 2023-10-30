package org.example.Models;

public class Entity {
    private String email;
    private String source;
    private double mailWithAttachment;
    private double mailWithoutAttachment;
    private double spam;

    public Entity() {
    }

    public Entity(String email, String source, double mailWithAttachment, double mailWithoutAttachment, double spam) {
        this.email = email;
        this.source = source;
        this.mailWithAttachment = mailWithAttachment;
        this.mailWithoutAttachment = mailWithoutAttachment;
        this.spam = spam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getMailWithAttachment() {
        return mailWithAttachment;
    }

    public void setMailWithAttachment(double mailWithAttachment) {
        this.mailWithAttachment = mailWithAttachment;
    }

    public double getMailWithoutAttachment() {
        return mailWithoutAttachment;
    }

    public void setMailWithoutAttachment(double mailWithoutAttachment) {
        this.mailWithoutAttachment = mailWithoutAttachment;
    }
    public double getSpam() {
        return spam;
    }
    public void setSpam(double spam) {
        this.spam = spam;
    }
}
