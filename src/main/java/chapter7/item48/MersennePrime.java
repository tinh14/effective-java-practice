package chapter7.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrime {
    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, (bi) -> bi.nextProbablePrime());
    }

    // Parallelism fails to speed up when used with Stream.iterate and the intermediate limit operation.
    public static void main(String[] args) {
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .parallel()
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mersenne -> System.out.println(mersenne.bitLength() + " : " + mersenne));
    }
}
