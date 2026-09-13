package io.github.bgptii.ch10interfaces.practiceexercises;

public class E10_29Person implements E10_29Comparable {

    private final String name;


    public E10_29Person(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Object otherObject) {
        if (!(otherObject instanceof E10_29Person)) {
            throw new IllegalArgumentException("Object must be a Person");
        }
        E10_29Person p = (E10_29Person) otherObject;
        String otherName = p.getName();
        String thisName = getName();
        int otherLength = otherName.length();
        int thisLength = thisName.length();
        int longerLength = Math.max(otherLength, thisLength);
        for (int i = 0; i < longerLength; i++) {
            if (i >= otherLength) {
                return 1; // other ended first, so this name is longer
            }
            else if (i >= thisLength) {
                return -1; // this ended first, so this name comes first
            }
            char cOther = otherName.charAt(i);
            char cThis = thisName.charAt(i);
            if (cOther > cThis) {
                return -1;
            }
            else if (cThis > cOther) {
                return 1;
            }
        }
        return 0;
    }

}
