package chapter4.item17.shape;

import java.util.*;

public class Test {

    // Written by ChatGPT :P
    public static void main(String[] args) {
        // --- Test Circle ---
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(5.0);
        Circle c3 = c1.radius(10.0); // returns a new instance

        System.out.println("=== Circle ===");
        System.out.println(c1);
        System.out.println(c3);
        System.out.println("c1 equals c2: " + c1.equals(c2)); // true
        System.out.println("c1 equals c3: " + c1.equals(c3)); // false

        System.out.println("c1 hashCode: " + c1.hashCode());
        System.out.println("c2 hashCode: " + c2.hashCode());
        System.out.println("c3 hashCode: " + c3.hashCode());

        System.out.println("c1 compareTo c3: " + c1.compareTo(c3)); // -1
        System.out.println("c1 compareTo c2: " + c1.compareTo(c2)); // 0
        System.out.println("c3 compareTo c1: " + c3.compareTo(c1)); // 1


        // --- Test Rectangle ---
        Rectangle r1 = new Rectangle(4.0, 6.0);
        Rectangle r2 = new Rectangle(4.0, 6.0);
        Rectangle r3 = r1.length(8.0);

        System.out.println("\n=== Rectangle ===");
        System.out.println(r1);
        System.out.println(r3);
        System.out.println("r1 equals c2: " + r1.equals(r2)); // true
        System.out.println("r1 equals r3: " + r1.equals(r3)); // false

        System.out.println("r1 hashCode: " + r1.hashCode());
        System.out.println("r2 hashCode: " + r2.hashCode());
        System.out.println("r3 hashCode: " + r3.hashCode());

        System.out.println("r1 compareTo r3: " + r1.compareTo(r3)); // -1
        System.out.println("r1 compareTo r2: " + r1.compareTo(r2)); // 0
        System.out.println("r3 compareTo r1: " + r3.compareTo(r1)); // 1

        // --- Test Square ---
        Square s1 = new Square(5.0);
        Square s2 = new Square(5.0);
        Square s3 = s1.side(10.0);

        System.out.println("\n=== Rectangle ===");
        System.out.println(s1);
        System.out.println(s3);
        System.out.println("s1 equals s2: " + s1.equals(s2)); // true
        System.out.println("s1 equals s3: " + s1.equals(s3)); // false

        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s2 hashCode: " + s2.hashCode());
        System.out.println("s3 hashCode: " + s3.hashCode());

        System.out.println("s1 compareTo s3: " + s1.compareTo(s3)); // -1
        System.out.println("s1 compareTo s2: " + s1.compareTo(s2)); // 0
        System.out.println("s3 compareTo s1: " + s3.compareTo(s1)); // 1

        // --- Test collections ---
        Set<Shape> hashSet = new HashSet<>();
        hashSet.add(c1);
        hashSet.add(c3);
        hashSet.add(r1);
        hashSet.add(r3);
        hashSet.add(s1);
        hashSet.add(s3);

        System.out.println("\n=== Shapes in HashSet ===");
        hashSet.forEach(System.out::println);

        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::area); // compare by area

        // --- Sorting test ---
        Set<Shape> treeSet = new TreeSet<>(comparator);
        treeSet.add(c1);
        treeSet.add(c3);
        treeSet.add(r1);
        treeSet.add(r3);
        treeSet.add(s1);
        treeSet.add(s3);

        System.out.println("\n=== Shapes in TreeSet ===");
        treeSet.forEach(System.out::println);
    }
}
