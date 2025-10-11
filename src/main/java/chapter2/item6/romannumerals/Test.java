package chapter2.item6.romannumerals;

public class Test {
    public static void main(String[] args) throws Exception {
        RomanNumerals dumpRomanNumerals = new DumpRomanNumerals();
        RomanNumerals smartRomanNumerals = new SmartRomanNumerals();

        int numSets = 5;
        int numReps = 10_000_000;
        boolean b = false;
        long totalSmartTime = 0;
        long totalDumpTime = 0;

        System.out.println("\n=== Smart version ===");
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                b ^= smartRomanNumerals.isRomanNumeral("MCMLXXVI");
            }
            long end = System.nanoTime();
            long elapsed = end - start;

            System.out.println((elapsed / (1_000.0 * numReps)) + " μs.");
            totalDumpTime += elapsed;
            System.out.println("Smart run #" + (i + 1) + ": " + (elapsed / 1_000_000.0) + " ms");
        }

        System.out.println("=== Total Smart time ===");
        System.out.println((totalDumpTime / 1_000_000_000.0) + " s total for all " + numSets + " runs");

        System.out.println("=== Dump version ===");
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < numReps; j++) {
                b ^= dumpRomanNumerals.isRomanNumeral("MCMLXXVI");
            }
            long end = System.nanoTime();
            long elapsed = end - start;

            System.out.println((elapsed / (1_000.0 * numReps)) + " μs.");

            totalSmartTime += elapsed;
            System.out.println("Dump run #" + (i + 1) + ": " + (elapsed / 1_000_000.0) + " ms");
        }

        System.out.println("=== Total Dump time ===");
        System.out.println((totalSmartTime / 1_000_000_000.0) + " s total for all " + numSets + " runs");

        if (!b) System.out.println();
    }
}
