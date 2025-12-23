package chapter8.item52.collectionclassifier;

import java.math.BigInteger;
import java.util.*;

public class CollectionClassifier {

    public static String classify(Collection<?> c) {
        return switch (c) {
            case Set<?> s -> "Set";
            case List<?> lst -> "List";
            default -> "Unknown Collection";
        };
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}
