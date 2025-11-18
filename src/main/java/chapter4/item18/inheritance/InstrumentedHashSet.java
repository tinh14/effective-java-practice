package chapter4.item18.inheritance;

import java.util.Collection;
import java.util.HashSet;

// Breaks parent's encapsulation
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount;

    public InstrumentedHashSet(){}

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

}
