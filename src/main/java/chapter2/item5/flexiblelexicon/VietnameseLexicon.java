package chapter2.item5.flexiblelexicon;

import java.util.List;

public class VietnameseLexicon implements Lexicon {

    @Override
    public boolean isValid(String word) {
        return "xin chào".equals(word);
    }

    @Override
    public List<String> getSuggestions(String typo) {
        return List.of("Vietnam", "undefeated");
    }
}
