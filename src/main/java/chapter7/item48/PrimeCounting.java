package chapter7.item48;

import java.math.BigInteger;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimeCounting {
    static long count(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(i -> BigInteger.valueOf(i))
                .filter(bi -> bi.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args) {
        System.out.println(count(10_000_000));
    }
}
