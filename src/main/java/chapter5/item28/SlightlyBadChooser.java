package chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class SlightlyBadChooser<T> {

    private final T[] choices;

    public SlightlyBadChooser(Collection<T> choices) {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) choices.toArray();
        this.choices = result;
    }

    public T choose() {
        Random random = ThreadLocalRandom.current();
        return choices[random.nextInt(choices.length)];
    }
}
