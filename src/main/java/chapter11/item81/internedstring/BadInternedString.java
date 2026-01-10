package chapter11.item81.internedstring;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class BadInternedString {
    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static String intern(String s) {
        String result = map.get(s);
        if (result == null) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.put(s, s);
            result = s;
        }
        return result;
    }

    public static void main(String[] args) {
        Tester.test(BadInternedString::intern); // Different instances
    }
}
