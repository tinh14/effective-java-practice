package chapter3.item14;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public final class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    public String getValue() {
        return s;
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString scis) {
            return s.equalsIgnoreCase(scis.s);
        }
        return false;
    }

    @Override
    public String toString() {
        return s;
    }

    @Override
    public int compareTo(CaseInsensitiveString other) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, other.s);
    }

    public static void main(String[] args) {
        Set<CaseInsensitiveString> set = new TreeSet<>();
        set.add(new CaseInsensitiveString("a"));
        set.add(new CaseInsensitiveString("c"));
        set.add(new CaseInsensitiveString("b"));

        set.add(new CaseInsensitiveString("A"));
        set.add(new CaseInsensitiveString("B"));

        System.out.println(set);
    }
}
