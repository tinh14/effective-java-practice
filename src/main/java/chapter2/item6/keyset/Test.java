package chapter2.item6.keyset;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        Set<String> keySet1 = map.keySet();
        Set<String> keySet2 = map.keySet();

        System.out.println("Keyset: " + keySet1);

        keySet2.remove("key1");

        System.out.println("Keyset: " + keySet1);
    }

}
