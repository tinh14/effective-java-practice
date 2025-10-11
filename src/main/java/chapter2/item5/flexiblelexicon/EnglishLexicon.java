package chapter2.item5.flexiblelexicon;

import java.util.List;

public class EnglishLexicon implements Lexicon{

    @Override
    public boolean isValid(String word) {
        return "hello".equals(word);
    }

    @Override
    public List<String> getSuggestions(String typo) {
        return List.of("foo", "bar", "baz");
    }
}
