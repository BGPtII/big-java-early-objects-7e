package io.github.bgptii.ch12objectorienteddesign.exercises;

import java.io.Serializable;
import java.util.ArrayList;

public class E12_6Mailbox implements Serializable {

    private final ArrayList<E12_6Email> inbox;
    private final ArrayList<E12_6Email> sent;

    public E12_6Mailbox() {
        inbox = new ArrayList<>();
        sent = new ArrayList<>();
    }

    public ArrayList<E12_6Email> getInbox() {
        return inbox;
    }

    public ArrayList<E12_6Email> getSent() {
        return sent;
    }

    public void addSent(E12_6Email email) {
        sent.add(email);
    }

    public void addInbox(E12_6Email email) {
        inbox.add(email);
    }

}
