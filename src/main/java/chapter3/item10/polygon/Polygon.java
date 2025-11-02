package chapter3.item10.polygon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Polygon {
    private final List<Point> vertices;
    private final double cachedArea;

    public Polygon(List<Point> vertices) {
        this.vertices = new ArrayList<>(vertices);
        this.cachedArea = calculateArea();
    }

    private double calculateArea() {
        double area = 0.0;
        for (int i = 0; i < vertices.size(); i++) {
            Point p1 = vertices.get(i);
            Point p2 = vertices.get((i + 1) % vertices.size());
            area += (p1.x * p2.y - p2.x * p1.y);
        }
        return Math.abs(area / 2.0);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(cachedArea);
        result = 31 * result + vertices.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Polygon p))
            return false;

        if (Double.compare(cachedArea, p.cachedArea) != 0)
            return false;

        if (vertices.size() != p.vertices.size())
            return false;

        return IntStream.range(0, vertices.size())
                .allMatch(i -> vertices.get(i).equals(p.vertices.get(i)));
    }
}
