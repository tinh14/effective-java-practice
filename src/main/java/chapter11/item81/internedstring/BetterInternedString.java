package chapter11.item81.internedstring;

import java.util.concurrent.ConcurrentHashMap;

public class BetterInternedString {
    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public static String intern(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null)
                result = s;
        }
        return result;
    }
    public static void main(String[] args) {
        Tester.test(BetterInternedString::intern); // Same instance
    }
}
