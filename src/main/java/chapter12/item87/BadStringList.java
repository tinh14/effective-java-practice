package chapter12.item87;

import java.io.Serializable;

public class BadStringList implements Serializable {

    private int size = 0;
    private Entry head = null;

    private static class Entry implements Serializable {
        String data;
        Entry next;
        Entry previous;
    }

    public final void add(String s) {}

}
