package chapter4.item24.staticmember;

import java.util.*;

public final class GoogleMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

    // static member class
    private static class Node<K, V> implements Map.Entry<K, V> {

        final K key;
        V value;
        Node<K,V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            V temp = value;
            value = newValue;
            return temp;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }
}
