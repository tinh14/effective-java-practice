package chapter3.item10.polygon;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Point> points1 = Arrays.asList(new Point(0, 0), new Point(4, 0), new Point(4, 3));
        List<Point> points2 = Arrays.asList(new Point(0, 0), new Point(4, 0), new Point(4, 3));

        Polygon p1 = new Polygon(points1);
        Polygon p2 = new Polygon(points2);

        System.out.println("p1.equals(p2) = " + p1.equals(p2)); // true
        System.out.println("p1.hashCode() = " + p1.hashCode());
        System.out.println("p2.hashCode() = " + p2.hashCode());
    }
}
