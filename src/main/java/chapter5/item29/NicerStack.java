package chapter5.item29;

import chapter2.item7.stack.EmptyStackException;

import java.util.Arrays;

public class NicerStack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public NicerStack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
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
        E e = elements[--size];
        elements[size] = null;
        return e;
    }
}
