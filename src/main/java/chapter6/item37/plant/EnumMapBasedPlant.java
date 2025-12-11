package chapter6.item37.plant;

import java.util.*;
import java.util.stream.Collectors;

public class EnumMapBasedPlant {
    public enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    private final String name;
    private final LifeCycle lifeCycle;

    public EnumMapBasedPlant(String name, LifeCycle cycle) {
        this.name = name;
        this.lifeCycle = cycle;
    }

    public String name() {
        return name;
    }

    public LifeCycle lifeCycle() {
        return lifeCycle;
    }

    public static Map<LifeCycle, Set<EnumMapBasedPlant>> plantsByLifeCycle(EnumMapBasedPlant[] garden) {

        Map<LifeCycle, Set<EnumMapBasedPlant>> plantsByLifeCycle = new EnumMap<>(LifeCycle.class);

        for (LifeCycle lifeCycle : LifeCycle.values())
            plantsByLifeCycle.put(lifeCycle, new HashSet<>());

        for (EnumMapBasedPlant plant : garden)
            plantsByLifeCycle.get(plant.lifeCycle).add(plant);

        return plantsByLifeCycle;
    }

    public static Map<LifeCycle, Set<EnumMapBasedPlant>> plantsByLifeCycle2(EnumMapBasedPlant[] garden) {
        // If we use two-parameters Collectors.grouping method, the Map implementation is a default Map, not an EnumMap

        return Arrays.stream(garden).collect(
                Collectors.groupingBy(
                        p -> p.lifeCycle,
                        () -> new EnumMap<>(LifeCycle.class),
                        Collectors.toSet()
                )
        );
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        EnumMapBasedPlant[] garden = {
                new EnumMapBasedPlant("Basil",    LifeCycle.ANNUAL),
                new EnumMapBasedPlant("Carroway", LifeCycle.BIENNIAL),
                new EnumMapBasedPlant("Dill",     LifeCycle.ANNUAL),
                new EnumMapBasedPlant("Lavendar", LifeCycle.PERENNIAL),
                new EnumMapBasedPlant("Parsley",  LifeCycle.BIENNIAL),
                new EnumMapBasedPlant("Rosemary", LifeCycle.PERENNIAL)
        };

        System.out.println(EnumMapBasedPlant.plantsByLifeCycle(garden));
        System.out.println(EnumMapBasedPlant.plantsByLifeCycle2(garden));
    }
}
