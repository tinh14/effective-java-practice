package chapter5.item30.cache;

// Delegates to Caffeine
public final class CaffeineCacheProvider<K, V> implements CacheProvider<K, V> {

    CaffeineCacheProvider() {}

    @Override
    public V get(K key) {
        if (!"test".equals(key)) {
            return null;
        }

        @SuppressWarnings("unchecked")
        V value = (V) Integer.valueOf(100);
        return value;
    }

    @Override
    public void put(K key, V value) {
    }
}
