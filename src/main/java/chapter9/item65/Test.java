package chapter9.item65;

import java.lang.reflect.Constructor;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        try {
            @SuppressWarnings("unchecked")
            // Substitutes TreeSet for HashSet to guarantee iteration ordering
            Class<? extends Set<Integer>> clazz =
                    (Class<? extends Set<Integer>>) Class.forName("java.util.HashSet");

            Constructor<? extends Set<Integer>> constructor = clazz.getDeclaredConstructor();
            // Creates an instance and accesses it via its interface known at compile-time
            Set<Integer> set = constructor.newInstance();
            set.addAll(Set.of(1, 5, 10, 15, 30, 35, 50, 75, 90, 100));

            System.out.println(set);

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (NoSuchMethodException e) {
            System.out.println("Parameterless constructor not found");
        } catch (ReflectiveOperationException e) {
            System.out.println("Constructor error");
        }
    }
}
