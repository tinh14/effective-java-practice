package chapter5.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class Chooser<T> {

    private final List<T> choices;

    public Chooser(Collection<? extends T> choices) {
        this.choices = new ArrayList<>(choices);
    }

    public T choose() {
        Random random = ThreadLocalRandom.current();
        return choices.get(random.nextInt(choices.size()));
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2 ,3, 4);
        Chooser<Number> chooser = new Chooser<>(list);
        Number number = chooser.choose();
        System.out.println("Choose: " + number);
    }
}
