package chapter4.item24.nonstaticmember;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public final class MindSet<E> extends AbstractSet<E> implements Set<E> {

    public MindSet() {}

    // Non-static member class
    private class MindSetIterator implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MindSetIterator();
    }

    @Override
    public int size() {
        return 0;
    }
}
