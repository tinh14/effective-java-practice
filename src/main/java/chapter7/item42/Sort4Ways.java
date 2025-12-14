package chapter7.item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort4Ways {

    private static void printAndShuffle(List<String> words) {
        System.out.println(words);
        Collections.shuffle(words);
    }

    public static void main(String[] args) {

        List<String> words = new ArrayList<>(List.of("a", "c", "d", "b"));

        // Anonymous class
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        printAndShuffle(words);

        // Lambda expression
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        printAndShuffle(words);

        // Method reference
        Collections.sort(words, Comparator.comparingInt(String::length));
        printAndShuffle(words);

        // Default method List.sort
        words.sort(Comparator.comparingInt(String::length));
        printAndShuffle(words);
    }
}
