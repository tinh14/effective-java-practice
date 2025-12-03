package chapter5.item29;

import chapter2.item7.stack.EmptyStackException;

import java.util.Arrays;

public class NiceStack<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public NiceStack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
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

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
        @SuppressWarnings("unchecked")
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }
}
