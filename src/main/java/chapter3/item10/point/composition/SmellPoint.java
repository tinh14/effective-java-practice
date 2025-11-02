package chapter3.item10.point.composition;

public class SmellPoint {

    private final Point point;
    private final String smell;

    public SmellPoint(int x, int y, String smell) {
        point = new Point(x, y);
        this.smell = smell;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public int hashCode() {
        return 31 * point.hashCode() + smell.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SmellPoint))
            return false;
        SmellPoint sp = (SmellPoint) o;
        return sp.point.equals(point) && sp.smell.equals(smell);
    }
}