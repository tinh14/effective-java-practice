package chapter12.item88.fixed;

import chapter12.Serializers;
import chapter12.item88.broken.BrokenPeriod;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class FixedPeriod implements Serializable {
    private Date start;
    private Date end;

    public FixedPeriod(Date start, Date end) {
        // Creates defensive copies of the mutable parameters
        // before enforcing invariants
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        // Checks the copied components, not the provided parameters!
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException("The start date must not be after the end one");
    }

    public Date start() {
        return new Date(start.getTime()); // Returns a copied component
    }

    public Date end() {
        return new Date(end.getTime()); // Returns a copied component
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return "Start: " + formatter.format(start) + ", end: " + formatter.format(end);
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (start.compareTo(end) > 0)
            throw new InvalidObjectException("The start date must not be after the end one");
    }

    private static byte[] generateSerializedForm() throws Exception {
        Date start = new Date();
        Date end = new Date(start.getTime() + 1000);
        FixedPeriod period = new FixedPeriod(start, end);
        System.out.println(period); // Works fine

        // Uses Reflection API to access to the private start field and modify it
        Field startField = FixedPeriod.class.getDeclaredField("start");
        startField.setAccessible(true);
        long fiveYearsInMs = 5L * 365 * 24 * 60 * 60 * 1000;
        start = new Date(start.getTime() + fiveYearsInMs);
        startField.set(period, start); // Changes the start field without enforcing invariants

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(period);
        out.close();

        return bos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        final byte[] serializedForm = generateSerializedForm();
        BrokenPeriod period = (BrokenPeriod) Serializers.deserialize(serializedForm);
        System.out.println(period);
    }

}
