package chapter7.item43;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<String> strings = List.of("a", "a", "b", "c", "d", "d");
        Map<String, Integer> frequencyTable = new HashMap<>();

        for (String str : strings)
            frequencyTable.merge(str, 1, (count, increment) -> count + increment);
        System.out.println(frequencyTable);
        frequencyTable.clear();

        for (String str : strings)
            frequencyTable.merge(str, 1, Integer::sum);
        System.out.println(frequencyTable);
    }
}
