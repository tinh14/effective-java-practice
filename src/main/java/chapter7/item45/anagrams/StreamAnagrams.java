package chapter7.item45.anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAnagrams {
    public static void main(String[] args) {
        int minSizeGroup = 3;
        String path = "src/main/java/chapter7/item45/anagrams/anagrams.txt";

        try (Stream<String> words = Files.lines(Path.of(path))) {
            words.collect(
                    Collectors.groupingBy(word -> word.chars().sorted()
                            .collect(StringBuilder::new,
                                    (sb, c) -> sb.append((char) c),
                                    (StringBuilder::append)).toString()))
                    .values().stream()
                    .filter(group -> group.size() >= minSizeGroup)
                    .map(group -> "Group size: " + group.size() + " - " + "Group: " + group)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
