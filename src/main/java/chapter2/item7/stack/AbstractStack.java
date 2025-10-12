package chapter2.item7.stack;

import java.util.Arrays;

public abstract class AbstractStack {
    protected Object[] elements;
    protected int size = 0;
    protected static final int DEFAULT_INITIAL_CAPACITY = 16;

    protected AbstractStack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    protected void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract Object pop();
}
