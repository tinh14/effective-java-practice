package chapter6.item40;

import java.util.HashSet;
import java.util.Set;

public class Bigram2 {
    private final char first;
    private final char second;

    public Bigram2(char first, char second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Bigram2 b))
            return false;
        return b.first == first && b.second == second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    @Override
    public String toString() {
        return first + "" + second;
    }

    public static void main(String[] args) {
        Set<Bigram2> bigrams = new HashSet<>();
        for (int i = 0; i < 10; i++)
            for (char c = 'a'; c <= 'z'; c++)
                bigrams.add(new Bigram2(c, c));

        System.out.println(bigrams);
        System.out.println(bigrams.size());
    }
}
