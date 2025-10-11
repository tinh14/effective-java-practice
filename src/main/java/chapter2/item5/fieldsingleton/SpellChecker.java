package chapter2.item5.fieldsingleton;

import java.lang.reflect.Constructor;
import java.util.List;

public class SpellChecker {
    private static final Lexicon dictionary = new Lexicon();

    private SpellChecker() {
        throw new AssertionError("Cannot instantiate SpellChecker object");
    }

    public static boolean isValid(String word) {
        String standardizedWord = word.toLowerCase();
        standardizedWord = standardizedWord.trim();

        // Delegate to dictionary instance
        return dictionary.isValid(standardizedWord);
    }

    public static List<String> suggestions(String typo) {
        return dictionary.getSuggestions(typo);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(SpellChecker.isValid("Hello"));
        System.out.println(SpellChecker.isValid("world"));
        System.out.println(SpellChecker.suggestions("f"));

        Constructor<SpellChecker> constructor = SpellChecker.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }

}
