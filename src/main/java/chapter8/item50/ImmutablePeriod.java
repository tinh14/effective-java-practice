package chapter8.item50;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ImmutablePeriod {
    private final LocalDate start;
    private final LocalDate end;

    public ImmutablePeriod(LocalDate start, LocalDate end) {
        if (start.isAfter(end))
            throw new IllegalArgumentException("The start date must not be after the end one");

        this.start = start;
        this.end = end;
    }

    public LocalDate start() {
        return start;
    }

    public LocalDate end() {
        return end;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "Start: " + formatter.format(start) + ", end: " + formatter.format(end);
    }

    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2025, 12, 22); // 22-12-2025
        LocalDate end = LocalDate.of(2025, 12, 23); // 23-12-2025

        ImmutablePeriod period = new ImmutablePeriod(start, end);
        System.out.println(period);

        // Returns a new instance of LocalDate with the provided state
        end.withDayOfMonth(20); // 20-12-2025
        period.start().withDayOfMonth(24); // 24-12-2025

        System.out.println(period);
    }

}
