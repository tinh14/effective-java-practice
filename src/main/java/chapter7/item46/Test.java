package chapter7.item46;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class Test {
    public static void main(String[] args) {
        List<String> strings = List.of("a", "a", "b", "c", "d", "d");

        // Use the Stream APIs but not the functional paradigm!
        Map<String, Long> frequencyTable = new HashMap<>();
        for (String str : strings)
            frequencyTable.merge(str, 1L, Long::sum);
        System.out.println(frequencyTable);

        Map<String, Long> frequencyTable2;
        frequencyTable2 = strings.stream()
                .collect(groupingBy(str -> str, counting()));
        System.out.println(frequencyTable2);

        List<String> top2 = frequencyTable2.keySet().stream()
                .sorted(comparing((String key) -> frequencyTable2.get(key)).reversed())
                .limit(2)
                .collect(toList());

        System.out.println(top2);
    }
}
