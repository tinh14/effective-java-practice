package chapter5.item30.cache;

public final class NoOpCacheProvider<K, V> implements CacheProvider<K, V> {

    NoOpCacheProvider() {}

    @Override
    public V get(K key) {
        return null; // always return null
    }

    @Override
    public void put(K key, V value) {
        // do nothing
    }
}
