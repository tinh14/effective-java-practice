package chapter4.item20;

import java.util.Map;
import java.util.Objects;

// Skeletal implementation
public abstract class SimpleImmutableEntry<K, V> implements Map.Entry<K, V> {

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (!(other instanceof Map.Entry e))
            return false;

        return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
    }

    @Override
    public int hashCode() {
        // Cannot use raw formula as before
        // because the key and value types are unknown at compile time.
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
