package chapter11.item81.internedstring;

import java.util.concurrent.ConcurrentHashMap;

public class FixedInternedString {
    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static String intern(String s) {
        String previousString = map.putIfAbsent(s, s);
        return previousString == null ? s : previousString;
    }
    public static void main(String[] args) {
        Tester.test(FixedInternedString::intern); // Same instance
    }
}
