package chapter11.item79.fixed;

import chapter4.item18.composition.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Observable<E> extends ForwardingSet<E> {

    private final List<Observer<E>> observers = new ArrayList<>();

    public Observable(Set<E> s) {
        super(s);
    }

    public void addObserver(Observer<E> observer) {
        synchronized(observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(Observer<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
        List<Observer<E>> snapshot;

        synchronized (observers) {
            snapshot = new ArrayList<>(observers);
        }

        // Moves alien methods out of the synchronized block
        // and iterates over the snapshot of the observers
        for (Observer<E> observer : snapshot)
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
