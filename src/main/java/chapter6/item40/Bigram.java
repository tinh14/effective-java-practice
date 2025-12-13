package chapter6.item40;

import java.util.HashSet;
import java.util.Set;

public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Bigram other) {
        return other.first == first && other.second == second;
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
        Set<Bigram> bigrams = new HashSet<>();
        for (int i = 0; i < 10; i++)
            for (char c = 'a'; c <= 'z'; c++)
                bigrams.add(new Bigram(c, c));

        System.out.println(bigrams);
        System.out.println(bigrams.size());
    }
}
