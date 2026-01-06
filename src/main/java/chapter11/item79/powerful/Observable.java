package chapter11.item79.powerful;

import chapter4.item18.composition.ForwardingSet;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Observable<E> extends ForwardingSet<E> {

    private final List<Observer<E>> observers = new CopyOnWriteArrayList<>();

    public Observable(Set<E> s) {
        super(s);
    }

    public void addObserver(Observer<E> observer) {
        observers.add(observer);
    }

    public boolean removeObserver(Observer<E> observer) {
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (Observer<E> observer : observers)
            observer.added(this, element);
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element);
        return result;
    }
}