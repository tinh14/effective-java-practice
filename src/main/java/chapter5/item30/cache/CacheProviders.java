package chapter5.item30.cache;

public final class CacheProviders {

    // Reuses this instance for all types
    private static final NoOpCacheProvider<?, ?> NO_OP_CACHE = new NoOpCacheProvider<>();

    private CacheProviders(){}

    public static <K, V> CacheProvider<K, V> primary() {
        return noOp();
    }

    public static <K, V> CacheProvider<K, V> caffeine() {
        return new CaffeineCacheProvider<>();
    }

    @SuppressWarnings("unchecked")
    public static <K, V> CacheProvider<K, V> noOp() {
        return (NoOpCacheProvider<K, V>) NO_OP_CACHE;
    }
}
