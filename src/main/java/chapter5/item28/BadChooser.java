package chapter5.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class BadChooser {

    private final Object[] choices;

    public BadChooser(Collection choices) {
        this.choices = choices.toArray();
    }

    // Users need to cast the returned type.
    // This may throw a ClassCastException
    public Object choose() {
        Random random = ThreadLocalRandom.current();
        return choices[random.nextInt(choices.length)];
    }
}
