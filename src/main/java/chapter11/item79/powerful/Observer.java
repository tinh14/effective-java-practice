package chapter11.item79.powerful;

@FunctionalInterface
public interface Observer<E> {
    void added(Observable<E> observable, E element);
}
