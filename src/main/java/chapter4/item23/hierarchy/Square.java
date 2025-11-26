package chapter4.item23.hierarchy;

// This design is accepted if Rectangle doesn't expose mutators.
public class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }
}
