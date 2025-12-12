package chapter6.item39.singleparameter;

public class Sample {
    @ExceptionTest(ArithmeticException.class)
    public static void m1() { // Should pass
        int x = 1 / 0;
    }
    @ExceptionTest(ArithmeticException.class)
    public static void m2() { // Should fail (wrong exception)
        int[] a = new int[0];
        int i = a[1]; // Throws ArrayIndexOutOfBoundsException
    }
    @ExceptionTest(ArithmeticException.class)
    public static void m3() { } // Should fail (no exception)
}
