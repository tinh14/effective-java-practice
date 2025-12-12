package chapter6.item39.marker;

public class Sample {
    @Testable
    public static void m1() { } // Should pass

    public static void m2() { }

    @Testable
    public static void m3() {
        throw new RuntimeException("Boom"); // Should fail
    }

    public static void m4() { } // Not a test

    @Testable
    public void m5() { }   // Invalid test method

    public static void m6() { } // Not a test

    @Testable
    public static void m7() {    // Should fail
        throw new RuntimeException("Crash");
    }

    public static void m8() { } // Not a test
}
