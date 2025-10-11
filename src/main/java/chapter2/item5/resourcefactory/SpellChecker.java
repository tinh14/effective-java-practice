package chapter2.item5.resourcefactory;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class SpellChecker {
    private final Supplier<Lexicon> dictionaryFactory;

    public SpellChecker(Supplier<Lexicon> dictionaryFactory) {
        this.dictionaryFactory = Objects.requireNonNull(dictionaryFactory);;
    }

    public boolean isValid(String word) {
        String standardizedWord = word.toLowerCase();
        standardizedWord = standardizedWord.trim();

        Lexicon dictionary = dictionaryFactory.get();
        // Delegate to dictionary instance
        return dictionary.isValid(standardizedWord);
    }

    public List<String> suggestions(String typo) {
        Lexicon dictionary = dictionaryFactory.get();
        return dictionary.getSuggestions(typo);
    }

    public Lexicon getLexicon() {
        return dictionaryFactory.get();
    }

    public static void main(String[] args) throws Exception {

        VietnameseLexicon vietnameseLexicon = new VietnameseLexicon();

        Supplier<Lexicon> englishFactory = EnglishLexicon::new;
        Supplier<Lexicon> vietnameseFactory = () -> vietnameseLexicon;

        SpellChecker englishSpellChecker = new SpellChecker(englishFactory);
        SpellChecker vietnameseSpellChecker = new SpellChecker(vietnameseFactory);

        Lexicon englishLexicon1 = englishSpellChecker.getLexicon();
        Lexicon englishLexicon2 = englishSpellChecker.getLexicon();
        System.out.println("English lexicon instances are the same: " + (englishLexicon1 == englishLexicon2));

        Runnable englishSpellcheckerTask = () -> {
            System.out.println("English-HASH: " + Objects.hashCode(englishSpellChecker.getLexicon()));
        };

        Runnable vietnameseSpellcheckerTask = () -> {
            System.out.println("Vietnamese-HASH: " + Objects.hashCode(vietnameseSpellChecker.getLexicon()));
        };

        System.out.println("Threading test:");

        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(englishSpellcheckerTask, "English-Thread-" + (i + 1));
            Thread t2 = new Thread(vietnameseSpellcheckerTask, "Vietnamese-Thread-" + (i + 1));
            t1.start();
            t2.start();
        }
    }

}
