package chapter4.item17.complex;

import java.util.Comparator;

public final class Complex implements Comparable<Complex> {
    private final double r;
    private final double i;

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    private Complex(double r, double i) {
        this.r = r;
        this.i = i;
    }

    public static Complex valueOf(double r, double i) {
        if (r == 0 && i == 0) return ZERO;
        if (r == 1 && i == 0) return ONE;
        if (r == 0 && i == 1) return I;
        return new Complex(r, i);
    }

    public double realPart() {
        return r;
    }

    public double imaginaryPart() {
        return i;
    }

    public Complex plus(Complex c) {
        return new Complex(r + c.r, i + c.i);
    }

    public Complex minus(Complex c) {
        return new Complex(r - c.i, i - c.i);
    }

    public Complex times(Complex c) {
        return new Complex(r * c.r - i * c.i, r * c.i + i * c.r);
    }

    public Complex dividedBy(Complex c) {
        double tmp = c.r * c.r + c.i * c.i;
        return new Complex((r * c.r + i * c.i) / tmp,
                (i * c.r - r * c.i) / tmp);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Complex c))
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
    public int compareTo(Complex other) {
        return Comparator.comparingDouble((Complex c) -> c.r)
                .thenComparingDouble(c -> c.i)
                .compare(this, other);
    }
}
