package chapter4.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

// Ordinary concrete implementation built on top of skeletal implementation
public class IntArray extends AbstractList<Integer> implements List<Integer> {

    private final int[] a;

    public IntArray(int[] a) {
        Objects.requireNonNull(a);
        this.a = a;
    }

    @Override
    public Integer get(int i) {
        return a[i];
    }
    @Override
    public Integer set(int i, Integer newVal) {
        int oldVal = a[i];
        a[i] = newVal;
        return oldVal;
    }

    @Override
    public int size() {
        return a.length;
    }
}
