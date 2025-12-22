package chapter8.item50;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DefensiveCopyPeriod {
    private final Date start;
    private final Date end;

    public DefensiveCopyPeriod(Date start, Date end) {
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

    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar(2025, Calendar.DECEMBER, 22);
        Date start = cal.getTime(); // 22-12-2025
        cal = new GregorianCalendar(2025, Calendar.DECEMBER, 23);
        Date end = cal.getTime(); // 23-12-2025

        DefensiveCopyPeriod period = new DefensiveCopyPeriod(start, end);
        System.out.println(period);

        // Changes the provided end date does not affect the internal state of period
        end.setDate(20); // 20-12-2025
        // Changes the exported start date does not affect the internal state of period
        period.start().setDate(24); // 24-12-2025

        System.out.println(period);
    }

}
