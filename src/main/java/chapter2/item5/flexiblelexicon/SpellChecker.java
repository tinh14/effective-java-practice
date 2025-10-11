package chapter2.item5.flexiblelexicon;

import java.util.List;

public class SpellChecker {
    private static Lexicon dictionary = new EnglishLexicon();

    private SpellChecker() {
        throw new AssertionError("Cannot instantiate SpellChecker object");
    }

    public static void setDictionary(Lexicon newDictionary) {
        dictionary = newDictionary;
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
        Lexicon englishLexicon = new EnglishLexicon();
        Lexicon vietnameseLexicon = new VietnameseLexicon();

        System.out.println(SpellChecker.isValid("Hello"));
        System.out.println(SpellChecker.isValid("world"));
        System.out.println(SpellChecker.suggestions("f"));

        SpellChecker.setDictionary(vietnameseLexicon);

        System.out.println(SpellChecker.isValid("Xin chào"));
        System.out.println(SpellChecker.suggestions("V"));

        Runnable englishSpellcheckerTask = () -> {
            String threadName = Thread.currentThread().getName();

            SpellChecker.setDictionary(englishLexicon);

            if (SpellChecker.isValid("Hello")) {
                System.out.printf("%s -> Word is valid: Hello%n", threadName);
            } else {
                System.out.printf("%s -> Word is NOT valid: Hello%n", threadName);
            }
        };

        Runnable vietnameseSpellcheckerTask = () -> {
            SpellChecker.setDictionary(vietnameseLexicon);
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
