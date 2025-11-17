package chapter4.item17.complexnumber;

import java.util.Comparator;

public abstract class ComplexNumber implements Comparable<ComplexNumber> {
    final double r;
    final double i;

    ComplexNumber(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public static ComplexNumber valueOf(double r, double i) {
        if (r == 0 && i == 0) return zero();
        if (r == 1 && i == 0) return one();
        if (r == 0 && i == 1) return i();

        return new SimpleComplexNumber(r, i);
    }
    public static ComplexNumber zero() {
        return Cache.ZERO;
    }
    public static ComplexNumber one() {
        return Cache.ONE;
    }
    public static ComplexNumber i() {
        return Cache.I;
    }

    public double realPart() {
        return r;
    }
    public double imaginaryPart() {
        return i;
    }

    abstract ComplexNumber plus(ComplexNumber c);
    abstract ComplexNumber minus(ComplexNumber c);
    abstract ComplexNumber times(ComplexNumber c);
    abstract ComplexNumber dividedBy(ComplexNumber c);

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof ComplexNumber c))
            return false;

        return Double.compare(r, c.r) == 0 && Double.compare(i, c.i) == 0;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(r);
        result = 31 * result + Double.hashCode(i);
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%f+%fi)", r, i);
    }

    @Override
    public int compareTo(ComplexNumber other) {
        return Comparator.comparingDouble((ComplexNumber c) -> c.r)
                .thenComparingDouble(c -> c.i)
                .compare(this, other);
    }

    private static class Cache {
        static final ComplexNumber ZERO = new SimpleComplexNumber(0, 0);
        static final ComplexNumber ONE = new SimpleComplexNumber(1, 0);
        static final ComplexNumber I = new SimpleComplexNumber(0, 1);
    }
}
