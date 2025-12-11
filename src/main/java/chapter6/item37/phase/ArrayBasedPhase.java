package chapter6.item37.phase;

public enum ArrayBasedPhase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        // Array based transitions
        // Rows indexed by "from" ordinal, columns indexed by "to" ordinal
        //
        // SOLID->SOLID   SOLID->LIQUID   SOLID->GAS
        // LIQUID->SOLID  LIQUID->LIQUID  LIQUID->GAS
        // GAS->SOLID     GAS->LIQUID     GAS->GAS
        private static final Transition[][] TRANSITIONS = {
                { null, MELT, SUBLIME },
                { FREEZE, null, BOIL },
                { DEPOSIT, CONDENSE, null }
        };

        // Returns the phase transition from one phase to another
        public static Transition from(ArrayBasedPhase from, ArrayBasedPhase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }

    public static void main(String[] args) {
        for (ArrayBasedPhase src : ArrayBasedPhase.values()) {
            for (ArrayBasedPhase dst : ArrayBasedPhase.values()) {
                Transition transition = Transition.from(src, dst);
                if (transition != null)
                    System.out.printf("%s to %s : %s %n", src, dst, transition);
            }
        }
    }
}
