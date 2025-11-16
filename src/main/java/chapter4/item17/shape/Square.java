package chapter4.item17.shape;

import java.util.Comparator;

public final class Square implements Shape, Comparable<Square> {

    private final Rectangle rectangle;
    private final double a;

    public Square(double a) {
        enforceInvariant(a);
        this.a = a;
        this.rectangle = new Rectangle(a, a);
    }

    @Override
    public double area() {
        return rectangle.area();
    }

    @Override
    public double perimeter() {
        return rectangle.perimeter();
    }

    @Override
    public String description() {
        return "Square";
    }

    private void enforceInvariant(double a) {
        if (a < 0)
            throw new IllegalArgumentException("Side cannot be less than 0");
    }

    public Square side(double a) {
        return new Square(a);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(a);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Square s))
            return false;

        return Double.compare(a, s.a) == 0;
    }

    @Override
    public String toString() {
        return String.format("Square(side=%f, area=%f, perimeter=%f, description=%s)", a, area(), perimeter(), description());
    }

    @Override
    public int compareTo(Square other) {
        return Comparator.comparingDouble((Square s) -> s.a)
                .compare(this, other);
    }
}
