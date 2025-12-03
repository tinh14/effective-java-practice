package chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class BetterChooser<T> {

    private final List<T> choices;

    public BetterChooser(Collection<T> choices) {
        this.choices = new ArrayList<>(choices);
    }

    public T choose() {
        Random random = ThreadLocalRandom.current();
        return choices.get(random.nextInt(choices.size()));
    }
}
