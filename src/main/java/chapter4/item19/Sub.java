package chapter4.item19;

import java.time.Instant;

public class Sub extends Super{
    private final Instant instant;

    public Sub() {
        instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        // Throws NullPointerException
        System.out.println(instant.getNano());
    }
}
