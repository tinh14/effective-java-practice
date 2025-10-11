package chapter2.item5.dependencyinjection;

import java.util.List;
import java.util.Objects;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);;
    }

    public boolean isValid(String word) {
        String standardizedWord = word.toLowerCase();
        standardizedWord = standardizedWord.trim();

        // Delegate to dictionary instance
        return dictionary.isValid(standardizedWord);
    }

    public List<String> suggestions(String typo) {
        return dictionary.getSuggestions(typo);
    }

    public static void main(String[] args) throws Exception {
        Lexicon englishLexicon = new EnglishLexicon();
        Lexicon vietnameseLexicon = new VietnameseLexicon();
        SpellChecker englishSpellChecker = new SpellChecker(englishLexicon);
        SpellChecker vietnameseSpellChecker = new SpellChecker(vietnameseLexicon);

        System.out.println(englishSpellChecker.isValid("Hello"));
        System.out.println(englishSpellChecker.isValid("world"));
        System.out.println(englishSpellChecker.suggestions("f"));

        System.out.println(vietnameseSpellChecker.isValid("Xin chào"));
        System.out.println(vietnameseSpellChecker.suggestions("V"));

        Runnable englishSpellcheckerTask = () -> {
            String threadName = Thread.currentThread().getName();

            if (englishSpellChecker.isValid("Hello")) {
                System.out.printf("%s -> Word is valid: Hello%n", threadName);
            } else {
                System.out.printf("%s -> Word is NOT valid: Hello%n", threadName);
            }
        };

        Runnable vietnameseSpellcheckerTask = () -> {
            String threadName = Thread.currentThread().getName();

            if (vietnameseSpellChecker.isValid("Xin chào")) {
                System.out.printf("%s -> Word is valid: Xin chào%n", threadName);
            } else {
                System.out.printf("%s -> Word is NOT valid: Xin chào%n", threadName);
            }
        };

        System.out.println("Threading test:");

//        singletons depend on underlying lexicon would be unworkable in concurrent environment
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(englishSpellcheckerTask, "English-Thread-" + (i + 1));
            Thread t2 = new Thread(vietnameseSpellcheckerTask, "Vietnamese-Thread-" + (i + 1));
            t2.start();
            t1.start();
        }
    }

}
