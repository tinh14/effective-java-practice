package chapter6.item37.phase;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EnumMapBasedPhase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        // from-phase -> to-phase -> transition
        //
        //           SOLID   -> null
        // SOLID  -> LIQUID  -> MELT
        //           GAS     -> SUBLIME
        //
        //        -> SOLID   -> FREEZE
        // LIQUID -> LIQUID  -> null
        //        -> GAS     -> BOIL
        //
        // So on...
        private static final Map<EnumMapBasedPhase, Map<EnumMapBasedPhase, Transition>> TRANSITIONS =
                Stream.of(values())
                        .collect(Collectors.groupingBy(
                            t -> t.from,
                            () -> new EnumMap<>(EnumMapBasedPhase.class),
                            Collectors.toMap(
                                    t -> t.to,
                                    Function.identity(),
                                    (x, y) -> y, // both old and new transition works for this situation
                                    () -> new EnumMap<>(EnumMapBasedPhase.class)
                            ))
                        );

        private final EnumMapBasedPhase from;
        private final EnumMapBasedPhase to;

        Transition(EnumMapBasedPhase from, EnumMapBasedPhase to) {
            this.from = from;
            this.to = to;
        }

        public static Transition from(EnumMapBasedPhase from, EnumMapBasedPhase to) {
            return TRANSITIONS.get(from).get(to);
        }
    }

    public static void main(String[] args) {
        for (EnumMapBasedPhase src : values()) {
            for (EnumMapBasedPhase dst : values()) {
                Transition transition = Transition.from(src, dst);
                if (transition != null)
                    System.out.printf("%s to %s : %s %n", src, dst, transition);
            }
        }
    }
}
