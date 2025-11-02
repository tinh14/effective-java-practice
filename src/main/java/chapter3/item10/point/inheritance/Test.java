package chapter3.item10.point.inheritance;

import chapter3.item10.point.Color;

public class Test {
    public static void main(String[] args) {
        // Erratic behavior of Timestamp class
        java.util.Date d = new java.util.Date(1234567890L);
        java.sql.Timestamp ts = new java.sql.Timestamp(1234567890L);
        System.out.println("Erratic behavior of Timestamp class: ");
        System.out.println("Date equals Timestamp: " + d.equals(ts));
        System.out.println("Timestamp equals Date: " + ts.equals(d));
        System.out.println();

        // Symmetry requirement check
        Point a1 = new Point(1, 2);
        ColorPoint b1 = new ColorPoint(1, 2, Color.RED);
        System.out.println("Symmetry requirement check: ");
        System.out.println("a equals b: " + a1.equals(b1));
        System.out.println("b equals a: " + b1.equals(a1));
        System.out.println();

        // Transitivity requirement check
        ColorPoint a2 = new ColorPoint(1, 2, Color.RED);
        Point b2 = new Point(1, 2);
        ColorPoint c2 = new ColorPoint(1, 2, Color.BLUE);
        System.out.println("Transitivity requirement check: ");
        System.out.println("a equals b: " + a2.equals(b2));
        System.out.println("b equals c: " + b2.equals(c2));
        System.out.println("a equals c: " + a2.equals(c2));
        System.out.println();

        // Liskov substitution principal check
        Point p = new Point(1,  0);
        Point cp = new CounterPoint(1,  0);
        Point sp = new SmellPoint(1, 0, "stinky");
        System.out.println("Liskov substitution principal check: ");
        System.out.println("Point instance: " + UnitCircleChecker.onUnitCircle(p));
        System.out.println("CounterPoint instance: " + UnitCircleChecker.onUnitCircle(cp));
        System.out.println("SmellPoint instance: " + UnitCircleChecker.onUnitCircle(sp));
        System.out.println();

        // Stack overflow error
        System.out.println("Stack overflow error: ");
        System.out.println("sp equals colorpoint: " + sp.equals(a2));
        System.out.println("colorpoint equals sp: " + a2.equals(sp));
    }
}
