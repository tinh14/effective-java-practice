package chapter11.item79.better;

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

    public void removeObserver(Observer<E> observer) {
        observers.remove(observer);
    }

    private void notify(E element) {
        for (Observer<E> observer : observers)
            observer.added(this, element);  
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notify(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean result = false;
        for (E element : collection)
            result |= add(element);
        return result;
    }
}
