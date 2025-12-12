package chapter6.item39.singleparameter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName("chapter6.item39.singleparameter.Sample");

        for (Method method : testClass.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(ExceptionTest.class)) {
                continue;
            }
            tests++;
            try {
                method.invoke(null);
                System.out.printf("Test %s failed: no exception%n", method);
            } catch (InvocationTargetException e) {
                Throwable exc = e.getCause();
                Class<? extends Throwable> excType = method.getAnnotation(ExceptionTest.class).value();
                if (excType.isInstance(exc)) {
                    passed++;
                } else {
                    System.out.printf("Test %s failed: expected %s, got %s%n", method, excType.getName(), exc);
                }
            } catch (Exception e) {
                System.out.println("Invalid @ExceptionTest: " + method);
            }
        }

        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
