package chapter7.item45.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.IntPredicate;

public class IterativeAnagrams {

    public static void main(String[] args) {
        int minSizeGroup = 3;
        String path = "src/main/java/chapter7/item45/anagrams/anagrams.txt";

        Map<String, List<String>> groups = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String word;
            while ((word = reader.readLine()) != null) {
                groups.computeIfAbsent(alphabetize(word), (unused) -> new ArrayList<>())
                        .add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("All groups");
        printGroup(groups.values(), (unused) -> true);

        System.out.println();

        System.out.println("Groups with a user-specified minium limit");
        printGroup(groups.values(), (size) -> size >= minSizeGroup);
    }

    private static String alphabetize(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private static void printGroup(Collection<List<String>> groups, IntPredicate condition) {
        for (List<String> group : groups) {
            if (condition.test(group.size())) {
                System.out.println("Group size: " + group.size() + " - " + "Group: " + group);
            }
        }
    }
}
