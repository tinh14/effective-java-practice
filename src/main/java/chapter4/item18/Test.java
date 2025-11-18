package chapter4.item18;

import chapter4.item18.composition.InstrumentedSet;
import chapter4.item18.inheritance.InstrumentedHashSet;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        InstrumentedHashSet<String> dumbSet = new InstrumentedHashSet<>();
        InstrumentedSet<String> smartSet = new InstrumentedSet<>(new HashSet<>());
        InstrumentedSet<String> anotherSmartSet = new InstrumentedSet<>(new TreeSet<>());

        List<String> items = List.of("Snap", "Crackle", "Pop");

        dumbSet.addAll(items);
        smartSet.addAll(items);
        anotherSmartSet.addAll(items);

        System.out.println("DumbSet: " + dumbSet.getAddCount());
        System.out.println("SmartSet: " + smartSet.getAddCount());
        System.out.println("AnotherSmartSet: " + smartSet.getAddCount());

        System.out.println(smartSet);
        System.out.println(anotherSmartSet);
    }
}
