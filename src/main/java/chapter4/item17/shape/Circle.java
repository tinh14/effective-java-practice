package chapter4.item17.shape;

import java.util.Comparator;

import static java.lang.Math.PI;

public final class Circle implements Shape, Comparable<Circle> {

    private final double r;

    public Circle(double r) {
        enforceInvariant(r);
        this.r = r;
    }

    @Override
    public double area() {
        return PI * r * r;
    }

    @Override
    public double perimeter() {
        return 2 * PI * r;
    }

    @Override
    public String description() {
        return "Circle";
    }

    private void enforceInvariant(double r) {
        if (r < 0)
            throw new IllegalArgumentException("Radius cannot be less than 0");
    }

    public Circle radius(double r) {
        return new Circle(r);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(r);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Circle c))
            return false;

        return Double.compare(r, c.r) == 0;
    }

    @Override
    public String toString() {
        return String.format("Circle(radius=%f, area=%f, perimeter=%f, description=%s)", r, area(), perimeter(), description());
    }

    @Override
    public int compareTo(Circle other) {
        return Comparator.comparingDouble((Circle c) -> c.r)
                .compare(this, other);
    }

}
