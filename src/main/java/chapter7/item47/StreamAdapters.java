package chapter7.item47;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamAdapters {
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        // Use Anonymous Class
//        return new Iterable<E>() {
//            @Override
//            public Iterator<E> iterator() {
//                return stream.iterator();
//            }
//        };
        // Use Lambda Expression
        return () -> stream.iterator();
    }

    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }
}
