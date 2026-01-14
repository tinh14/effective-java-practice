package chapter12.item87;

import java.io.*;

public class FixedStringList implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private transient int size = 0;
    private transient Entry head = null;

    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    public final void add(String s) {}

    /**
     * Serialize this {@code FixedStringList} instance.
     *
     * @serialData The size of the list, followed by all of its elements in a proper sequence.
     */
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(size);

        for (Entry e = head; e != null; e = e.next)
            out.writeObject(e.data);
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int readSize = in.readInt();

        for (int i = 0; i < readSize; i++)
            add((String) in.readObject());

    }
}
