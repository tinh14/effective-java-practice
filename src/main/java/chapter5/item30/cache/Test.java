package chapter5.item30.cache;

import java.math.BigInteger;

public class Test {

    private static int loadFromDatabase() {
        return 1;
    }

    public static void main(String[] args) {
        CacheProvider<String, Integer> caffeineCache = CacheProviders.caffeine();
        CacheProvider<String, Integer> noOpCache = CacheProviders.noOp();
        CacheProvider<Long, BigInteger> noOpCache2 = CacheProviders.primary();

        Integer result1 = caffeineCache.get("test");
        if (result1 == null) {
            result1 = loadFromDatabase();
        }
        System.out.println(result1); // Prints 100

        Integer result2 = noOpCache.get("test"); // Always returns null
        if (result2 == null) {
            result2 = loadFromDatabase();
        }
        System.out.println(result2); // Prints 1

        System.out.println(noOpCache.equals(noOpCache2)); // Same instance
    }
}
