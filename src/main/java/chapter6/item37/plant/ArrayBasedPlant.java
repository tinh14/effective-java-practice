package chapter6.item37.plant;

import java.util.HashSet;
import java.util.Set;

public class ArrayBasedPlant {
    public enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    private final String name;
    private final LifeCycle lifeCycle;

    public ArrayBasedPlant(String name, LifeCycle cycle) {
        this.name = name;
        this.lifeCycle = cycle;
    }

    public String name() {
        return name;
    }

    public LifeCycle lifeCycle() {
        return lifeCycle;
    }

    public static Set<ArrayBasedPlant>[] plantsByLifeCycle(ArrayBasedPlant[] garden) {
        @SuppressWarnings("unchecked")
        Set<ArrayBasedPlant>[] plantsByLifeCycle = (Set<ArrayBasedPlant>[]) new Set[LifeCycle.values().length];

        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        for (ArrayBasedPlant plant : garden)
            plantsByLifeCycle[plant.lifeCycle.ordinal()].add(plant);

        return plantsByLifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        ArrayBasedPlant[] garden = {
                new ArrayBasedPlant("Basil",    LifeCycle.ANNUAL),
                new ArrayBasedPlant("Carroway", LifeCycle.BIENNIAL),
                new ArrayBasedPlant("Dill",     LifeCycle.ANNUAL),
                new ArrayBasedPlant("Lavendar", LifeCycle.PERENNIAL),
                new ArrayBasedPlant("Parsley",  LifeCycle.BIENNIAL),
                new ArrayBasedPlant("Rosemary", LifeCycle.PERENNIAL)
        };

        Set<ArrayBasedPlant>[] plantsByLifeCycle = ArrayBasedPlant.plantsByLifeCycle(garden);
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    ArrayBasedPlant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }

    }
}
