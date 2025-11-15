package chapter4.item16;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Point implements Cloneable, Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this(other.x, other.y);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Point p))
            return false;

        return this.x == p.x && this.y == p.y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    @Override
    public Point clone() {
        try {
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public int compareTo(Point other) {
        return Comparator.comparing((Point p) -> p.x)
                .thenComparing(p -> p.y)
                .compare(this, other);
    }

    public static Point copyOf(Point point) {
        return new Point(point.x, point.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public static void main(String[] args) {
        Set<Point> ts = new TreeSet<>();

        ts.add(new Point(9, 0));
        ts.add(new Point(10, 0));
        ts.add(new Point(8, 0));
        ts.add(new Point(6, 0));
        ts.add(new Point(7, 0));
        System.out.println(ts);

        Set<Point> hs = new HashSet<>();
        hs.add(new Point(9, 0));
        hs.add(new Point(10, 0));
        hs.add(new Point(10, 1));
        hs.add(new Point(6, 0));
        hs.add(new Point(7, 0));
        System.out.println(hs);

        Point temp = new Point(10, 10);
        Point p = Point.copyOf(new Point(temp));

        System.out.println(p.equals(p.clone()));
        System.out.println(p.getClass() == p.clone().getClass());
    }
}
