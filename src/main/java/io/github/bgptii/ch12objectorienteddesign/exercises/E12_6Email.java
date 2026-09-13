package io.github.bgptii.ch12objectorienteddesign.exercises;

import java.time.LocalDateTime;

public class E12_6Email {

    private String sender;
    private String subject;
    private String recipient;
    private String messageText;
    private LocalDateTime dateSent;

    public E12_6Email(String sender, String subject, String recipient, String messageText, LocalDateTime dateSent) {
        this.sender = sender;
        this.subject = subject;
        this.recipient = recipient;
        this.messageText = messageText;
        this.dateSent = dateSent;
    }

    public String getSender() {
        return sender;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getDateSent() {
        return dateSent;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }
}
