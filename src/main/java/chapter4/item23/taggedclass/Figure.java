package chapter4.item23.taggedclass;

public class Figure {

    enum Shape { RECTANGLE, CIRCLE }

    final Shape shape;

    // Used only if shape is RECTANGLE
    double length;
    double width;

    // Used only if shape is CIRCLE
    double radius;

    // Constructor for circle
    Figure(double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for rectangle
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        return switch (shape) {
            case Shape.CIRCLE -> Math.PI * (radius * radius);
            case Shape.RECTANGLE -> length * width;
        };
    }
}
