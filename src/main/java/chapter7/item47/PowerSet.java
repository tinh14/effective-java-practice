package chapter7.item47;

import java.util.*;

public final class PowerSet {
    public static <E> Collection<Set<E>> of(Set<E> set) {
        List<E> src = new ArrayList<>(set);

        // Collection enforces exposing the number of elements contract
        // which is unnecessary for non-predetermined or infinite sequences.
        if (src.size() > 30)
            throw new IllegalArgumentException("Set too big " + set);

        return new AbstractList<>() {
            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                int i = 0;
                while (index != 0) {
                    if ((index & 1) == 1)
                        result.add(src.get(i));
                    i++;
                    index >>= 1;
                }
                return result;
            }

            @Override
            public int size() {
                return 1 << src.size();
            }
        };
    }

    public static void main(String[] args) {
        Set<String> set = Set.of("a", "b", "c");

        Collection<Set<String>> iteration = PowerSet.of(set);
        System.out.println("Iteration: " + iteration);

        List<Set<String>> stream = StreamAdapters.streamOf(iteration)
                .toList();
        System.out.println("Stream: " + stream);
        System.out.println("Specific subset: " + stream.get(5));

        Iterable<Set<String>> iterable = StreamAdapters.iterableOf(StreamAdapters.streamOf(stream));

        System.out.print("Iterable: ");
        for (Set<String> s : iterable) {
            System.out.print(s + " ");
        }
    }

}
