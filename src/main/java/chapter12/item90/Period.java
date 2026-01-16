package chapter12.item90;

import chapter12.Serializers;

import java.io.*;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Period implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
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

    private static class SerializationProxy implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private final Date start;
        private final Date end;

        public SerializationProxy(Period period) {
            this.start = period.start;
            this.end = period.end;
        }

        @Serial
        private Object readResolve() {
            return new Period(start, end);
        }
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        throw new InvalidObjectException("F*ck attacker!");
    }

    @Serial
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private static byte[] generateSerializedForm() throws Exception {
        Date start = new Date();
        Date end = new Date(start.getTime() + 1000);
        Period period = new Period(start, end);
        System.out.println(period); // Works fine

        // Uses Reflection API to access to the private start field and modify it
        Field startField = Period.class.getDeclaredField("start");
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
        Period period = (Period) Serializers.deserialize(serializedForm);
        System.out.println(period);
    }

}
