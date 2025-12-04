package chapter5.item30.cache;

public interface CacheProvider<K, V> {
    V get(K key);
    void put(K key, V value);
}
