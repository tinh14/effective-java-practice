package chapter12.item90;

import java.io.*;
import java.util.Date;

public class MutablePeriod {
    public final Period period;
    public final Date start;
    public final Date end;

    public MutablePeriod() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);

            // Serialize a valid Period instance
            out.writeObject(new Period(new Date(), new Date()));

            byte[] ref = { 0x71, 0, 0x7e, 0, 5 }; // Ref #5
            bos.write(ref); // The start field
            ref[4] = 4; // Ref # 4
            bos.write(ref); // The end field

            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

            period = (Period) in.readObject();
            start = (Date) in.readObject();
            end = (Date) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        MutablePeriod mutablePeriod = new MutablePeriod();
        Period period = mutablePeriod.period;
        System.out.println(period);

        Date start = mutablePeriod.start;
        long fiveYearsInMs = 5L * 365 * 24 * 60 * 60 * 1000;
        start.setTime(start.getTime() + fiveYearsInMs);

        System.out.println(period);
    }
}
