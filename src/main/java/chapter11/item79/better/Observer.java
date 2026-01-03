package chapter11.item79.better;

public interface Observer<E> {
    void added(Observable<E> observable, E element);
}
