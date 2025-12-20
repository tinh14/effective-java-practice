package chapter7.item47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubLists {
    public static <E> List<List<E>> listOf(List<E> list) {
        List<List<E>> subLists = new ArrayList<>();
        subLists.add(Collections.emptyList());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j <= list.size(); j++)
                subLists.add(list.subList(i, j));
        }

        return subLists;
    }

    public static <E> Stream<List<E>> streamOf(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
                prefixes(list).flatMap(prefix -> suffixes(prefix)));
    }

    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
                .mapToObj(i -> list.subList(0, i));
    }

    private static <E> Stream<List<E>> suffixes(List<E> prefix) {
        return IntStream.range(0, prefix.size())
                .mapToObj(j -> prefix.subList(j, prefix.size()));
    }

    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d");
        System.out.println(listOf(list));
        System.out.println(streamOf(list).toList());
    }
}
