package chapter4.item21;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class SynchronizedList<E> implements List<E> {
    private final List<E> delegate;
    private final Object lock;

    public SynchronizedList(List<E> list, Object lock) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(lock);

        this.delegate = list;
        this.lock = lock;
    }

    @Override
    public Iterator<E> iterator() {
        // Returns the underlying list iterator,
        // not current instance SynchronizedList's iterator
        return delegate.iterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return delegate.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return delegate.listIterator(index);
    }

    // Collection's default removeIf() method performs the removal on the returned iterator from iterator() method
    // which is overridden and returns the backing list iterator.
    // Modifies this iterator without synchronized block can cause race conditions, visibility issues or
    // ConcurrentModificationException throwing in concurrent environment.
//    @Override
//    public boolean removeIf(Predicate<? super E> filter) {
//        synchronized (lock) {
//            return delegate.removeIf(filter);
//        }
//    }

    @Override
    public int size() {
        synchronized (lock) {
            return delegate.size();
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (lock) {
            return delegate.isEmpty();
        }
    }

    @Override
    public boolean contains(Object o) {
        synchronized (lock) {
            return delegate.contains(o);
        }
    }

    @Override
    public Object[] toArray() {
        synchronized (lock) {
            return delegate.toArray();
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        synchronized (lock) {
            return delegate.toArray(a);
        }
    }

    @Override
    public boolean add(E e) {
        synchronized (lock) {
            return delegate.add(e);
        }
    }

    @Override
    public boolean remove(Object o) {
        synchronized (lock) {
            return delegate.remove(o);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        synchronized (lock) {
            return delegate.containsAll(c);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        synchronized (lock) {
            return delegate.addAll(c);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        synchronized (lock) {
            return delegate.addAll(index, c);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        synchronized (lock) {
            return delegate.removeAll(c);
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        synchronized (lock) {
            return delegate.retainAll(c);
        }
    }

    @Override
    public void clear() {
        synchronized (lock) {
            delegate.clear();
        }
    }

    @Override
    public E get(int index) {
        synchronized (lock) {
            return delegate.get(index);
        }
    }

    @Override
    public E set(int index, E element) {
        synchronized (lock) {
            return delegate.set(index, element);
        }
    }

    @Override
    public void add(int index, E element) {
        synchronized (lock) {
            delegate.add(index, element);
        }
    }

    @Override
    public E remove(int index) {
        synchronized (lock) {
            return delegate.remove(index);
        }
    }

    @Override
    public int indexOf(Object o) {
        synchronized (lock) {
            return delegate.indexOf(o);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        synchronized (lock) {
            return delegate.lastIndexOf(o);
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        synchronized (lock) {
            return delegate.subList(fromIndex, toIndex);
        }
    }

}
