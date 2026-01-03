package chapter11.item79.broken;

public interface Observer<E> {
    void added(Observable<E> observable, E element);
}
