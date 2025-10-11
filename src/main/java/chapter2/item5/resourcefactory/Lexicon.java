package chapter2.item5.resourcefactory;

import java.util.List;

public interface Lexicon {
    boolean isValid(String word);
    List<String> getSuggestions(String typo);
}
