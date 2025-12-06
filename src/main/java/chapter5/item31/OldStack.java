package chapter5.item31;

import chapter2.item7.stack.EmptyStackException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class OldStack<E> {

    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public OldStack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
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

    public void pushAll(Iterable<E> coll) {
        for (E e : coll)
            push(e);
    }

    public void popAll(Collection<E> coll) {
        while (!isEmpty()) {
            coll.add(pop());
        }
    }

    public static void main(String[] args) {
        OldStack<Integer> stack = new OldStack<>();
        stack.pushAll(List.of(1, 2));
        List<Number> des = new ArrayList<>();
//        nicerStack.popAll(des); // won't compile
    }
}
