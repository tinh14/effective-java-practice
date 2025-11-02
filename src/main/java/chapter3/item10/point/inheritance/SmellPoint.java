package chapter3.item10.point.inheritance;

public class SmellPoint extends Point {

    private final String smell;

    public SmellPoint(int x, int y, String smell) {
        super(x, y);
        this.smell = smell;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + smell.hashCode();
    }

    // Violates symmetry
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof SmellPoint))
//            return false;
//        return super.equals(o) && ((SmellPoint) o).smell == smell;
//    }

    // Violates transitivity
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;

        if (!(o instanceof SmellPoint))
            return o.equals(this);

        SmellPoint other = (SmellPoint) o;
        return super.equals(o) && this.smell.equals(other.smell);
    }
}