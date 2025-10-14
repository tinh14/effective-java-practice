package chapter2.item6.autoboxing;



public class Sum {

    private static long dumbSum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    private static long smartSum() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }

    public static void main(String[] args) throws Exception {

        int numSets = 5;
        long x = 0;

        System.out.println("Smart sum:");
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += smartSum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        System.out.println("Dumb sum:");
        for (int i = 0; i < numSets; i++) {
            long start = System.nanoTime();
            x += dumbSum();
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000. + " ms.");
        }

        // Prevents VM from optimizing away everything.
        if (x == 42)
            System.out.println();
    }
}
