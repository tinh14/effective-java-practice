package chapter8.item50;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class MutablePeriod {
    private final Date start;
    private final Date end;

    public MutablePeriod(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException("The start date must not be after the end one");
        this.start = start;
        this.end = end;
    }

    public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return "Start: " + formatter.format(start) + ", end: " + formatter.format(end);
    }

    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar(2025, Calendar.DECEMBER, 22);
        Date start = cal.getTime(); // 22-12-2025
        cal = new GregorianCalendar(2025, Calendar.DECEMBER, 23);
        Date end = cal.getTime(); // 23-12-2025

        MutablePeriod period = new MutablePeriod(start, end);
        System.out.println(period); // Fine

        // Changes the provided end date without enforcing invariants.
        end.setDate(20); // 20-12-2025
        // Changes the exported start date without enforcing invariants.
        period.start().setDate(24); // 24-12-2025

        System.out.println(period); // Wrong
    }

}
