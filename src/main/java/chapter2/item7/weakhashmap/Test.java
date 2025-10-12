package chapter2.item7.weakhashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Test {

    private static void testMemoryLeak(Map<String, User> cache) throws InterruptedException {

        for (int i = 0; i < 1_000_000; i++) {
            String key = "User " + i;
            cache.put(key, new User("User" + i));
        }

        System.gc(); // Enforce GC to run
        Thread.sleep(1000); // wait for GC to run

        System.out.println("Cache size after gc: " + cache.size());
    }

    public static void main(String[] args) throws InterruptedException {
        Map<String, User> strongCache = new HashMap<>();
        Map<String, User> weakCache = new WeakHashMap<>();

        System.out.println("Strong Cache Test:");
        testMemoryLeak(strongCache);

        System.out.println("Weak Cache Test:");
        testMemoryLeak(weakCache);
    }
}
