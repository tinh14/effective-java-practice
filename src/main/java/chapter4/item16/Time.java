package chapter4.item16;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public final class Time implements Cloneable, Comparable<Time> {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    public static final Comparator<Time> COMPARATOR =
            comparing((Time t) -> t.hour)
                    .thenComparing(t -> t.minute);

    public final int hour;
    public final int minute;

    public Time(int hour, int minute) {
        if (hour < 0 || hour > HOURS_PER_DAY)
            throw new IllegalArgumentException("Hour: " + hour);
        if (minute < 0 || minute > MINUTES_PER_HOUR)
            throw new IllegalArgumentException("Minute: " + minute);
        this.hour = hour;
        this.minute = minute;
    }

    public Time(Time time) {
        this(time.hour, time.minute);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(hour);
        result = 31 * result + Integer.hashCode(minute);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Time t))
            return false;

        return this.hour == t.hour && this.minute == t.minute;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }

    @Override
    public Time clone() {
        try {
            return (Time) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(Time other) {
        return COMPARATOR.compare(this, other);
    }

    public static Time copyOf(Time time) {
        return new Time(time.hour, time.minute);
    }

    public static void main(String[] args) {
        Set<Time> ts = new TreeSet<>(Time.COMPARATOR.reversed());

        ts.add(new Time(9, 0));
        ts.add(new Time(10, 0));
        ts.add(new Time(8, 0));
        ts.add(new Time(6, 0));
        ts.add(new Time(7, 0));
        System.out.println(ts);

        Set<Time> hs = new HashSet<>();
        hs.add(new Time(9, 0));
        hs.add(new Time(10, 0));
        hs.add(new Time(10, 1));
        hs.add(new Time(6, 0));
        hs.add(new Time(7, 0));
        System.out.println(hs);

        Time temp = new Time(10, 10);
        Time t = Time.copyOf(new Time(temp));

        System.out.println(t.equals(t.clone()));
        System.out.println(t.getClass() == t.clone().getClass());
    }
}
