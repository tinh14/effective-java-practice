package chapter2.item7.stack;

public class SmartStack extends AbstractStack {

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
        Object e = elements[--size];
        elements[size] = null;
        return e;
    }
}