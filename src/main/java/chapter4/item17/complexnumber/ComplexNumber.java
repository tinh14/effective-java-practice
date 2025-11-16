package chapter4.item17.complexnumber;

import java.util.Comparator;

public abstract class ComplexNumber implements Comparable<ComplexNumber> {
    public static final ComplexNumber ZERO = ComplexNumberCache.ZERO;
    public static final ComplexNumber ONE = ComplexNumberCache.ONE;
    public static final ComplexNumber I = ComplexNumberCache.I;

    final double r;
    final double i;

    ComplexNumber(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public static ComplexNumber valueOf(double r, double i) {
        if (r == 0 && i == 0) return ZERO;
        if (r == 1 && i == 0) return ONE;
        if (r == 0 && i == 1) return I;

        return new SimpleComplexNumber(r, i);
    }

    public double realPart() {
        return r;
    }

    public double imaginaryPart() {
        return i;
    }

    public abstract ComplexNumber plus(ComplexNumber c);
    public abstract ComplexNumber minus(ComplexNumber c);
    public abstract ComplexNumber times(ComplexNumber c);
    public abstract ComplexNumber dividedBy(ComplexNumber c);

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

    static class ComplexNumberCache {
        public static final ComplexNumber ZERO = new SimpleComplexNumber(0, 0);
        public static final ComplexNumber ONE = new SimpleComplexNumber(1, 0);
        public static final ComplexNumber I = new SimpleComplexNumber(0, 1);
    }
}
