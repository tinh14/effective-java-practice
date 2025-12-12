package chapter6.item39.marker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName("chapter6.item39.marker.Sample");

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Testable.class)) {
                tests++;
                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    Throwable exc = e.getCause();
                    System.out.println(method + " failed " + exc);
                } catch (Exception e) {
                    System.out.println("Invalid @Testable: " + method);
                }
            }
        }

        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
