package chapter7.item45;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrime {
    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, (bi) -> bi.nextProbablePrime());
    }

    public static void main(String[] args) {
        primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                // Mersenne numbers have an exponent equals to their bit length.
                .forEach(mersenne -> System.out.println(mersenne.bitLength() + " : " + mersenne));
    }
}
