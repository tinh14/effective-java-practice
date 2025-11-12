package chapter3.item14;

import java.util.Set;
import java.util.TreeSet;

public class Test {

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
