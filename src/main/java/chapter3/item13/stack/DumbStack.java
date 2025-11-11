package chapter3.item13.stack;

public class DumbStack extends TonyStack {

    // Clone method for class with references to mutable state
    @Override
    public DumbStack clone() {
        try {
            DumbStack result = (DumbStack) super.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
