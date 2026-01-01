package chapter11.item78.serialnumbergenerator;

public class BrokenSerialNumberGenerator {
    private static volatile int nextSerialNumber = 0;

    public static int generate() {
        return nextSerialNumber++;
    }
}
