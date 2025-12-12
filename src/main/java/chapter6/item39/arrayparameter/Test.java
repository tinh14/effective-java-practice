package chapter6.item39.arrayparameter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName("chapter6.item39.arrayparameter.Sample");

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
                int oldPassed = passed;
                Class<? extends Throwable>[] excTypes = method.getAnnotation(ExceptionTest.class).values();
                for (Class<? extends Throwable> excType : excTypes) {
                    if (excType.isInstance(exc)) {
                        passed++;
                        break;
                    }
                }

                 if (passed == oldPassed)
                     System.out.printf("Test %s failed: %s %n", method, exc);

            } catch (Exception e) {
                System.out.println("Invalid @ExceptionTest: " + method);
            }
        }

        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
