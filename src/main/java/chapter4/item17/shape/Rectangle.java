package chapter4.item17.shape;

import java.util.Comparator;

public final class Rectangle implements Shape, Comparable<Rectangle> {
    private final double l;
    private final double w;

    public Rectangle(double l, double w) {
        enforceInvariant(l, w);
        this.l = l;
        this.w = w;
    }

    @Override
    public double area() {
        return l * w;
    }

    @Override
    public double perimeter() {
        return 2 * (l + w);
    }

    @Override
    public String description() {
        return "Rectangle";
    }

    private void enforceInvariant(double l, double w) {
        if (l < 0 || w < 0)
            throw new IllegalArgumentException("Length or with cannot be less than 0");
    }

    public Rectangle length(double l) {
        return new Rectangle(l, this.w);
    }

    public Rectangle width(double w) {
        return new Rectangle(this.l, w);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(l);
        result = 31 * result + Double.hashCode(w);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Rectangle r))
            return false;

        return Double.compare(l, r.l) == 0 && Double.compare(w, r.w) == 0;
    }

    @Override
    public String toString() {
        return String.format("Rectangle(length=%f, width=%f, area=%f, perimeter=%f, description=%s)", l, w, area(), perimeter(), description());
    }

    @Override
    public int compareTo(Rectangle other) {
        return Comparator.comparingDouble((Rectangle r) -> r.l)
                .thenComparingDouble(r -> r.w)
                .compare(this, other);
    }
}
