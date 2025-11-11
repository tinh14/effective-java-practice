package chapter3.item13.stack;

public class SmartStack extends TonyStack {

    // Clone method for class with references to mutable state
    @Override
    public SmartStack clone() {
        try {
            SmartStack result = (SmartStack) super.clone();
            result.elements = this.elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
