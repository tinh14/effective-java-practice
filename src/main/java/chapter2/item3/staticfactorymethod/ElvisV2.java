package chapter2.item3.staticfactorymethod;

public class ElvisV2 {
    private static final ThreadLocal<ElvisV2> INSTANCES = ThreadLocal.withInitial(ElvisV2::new);

    private ElvisV2() {
    }

    public static ElvisV2 getInstance() {
        return INSTANCES.get();
    }
}