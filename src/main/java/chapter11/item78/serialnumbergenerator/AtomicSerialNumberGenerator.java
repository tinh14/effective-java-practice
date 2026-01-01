package chapter11.item78.serialnumbergenerator;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicSerialNumberGenerator {
    private static final AtomicLong nextSerialNumber = new AtomicLong(0);

    public static long generate() {
        return nextSerialNumber.incrementAndGet();
    }
}
