package chapter7.item45.anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HybridAnagrams {
    public static void main(String[] args) {
        int minSizeGroup = 3;
        String path = "src/main/java/chapter7/item45/anagrams/anagrams.txt";

        try (Stream<String> words = Files.lines(Path.of(path))) {
            words.collect(
                    Collectors.groupingBy(word -> alphabetize(word)))
                    .values().stream()
                    .filter(group -> group.size() >= minSizeGroup)
                    .map(group -> "Group size: " + group.size() + " - " + "Group: " + group)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String alphabetize(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
