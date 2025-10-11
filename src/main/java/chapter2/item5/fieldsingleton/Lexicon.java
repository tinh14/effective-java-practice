package chapter2.item5.fieldsingleton;

import java.util.List;
import java.util.Random;

public class Lexicon {
    private final Random random = new Random();

    public boolean isValid(String word) {
        return random.nextBoolean();
    }

    public List<String> getSuggestions(String typo) {
        return List.of("foo", "bar", "baz");
    }
}