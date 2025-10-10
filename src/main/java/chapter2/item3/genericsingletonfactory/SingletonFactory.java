package chapter2.item3.genericsingletonfactory;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class SingletonFactory {

    private static final Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

    public static <T> T getInstance(Class<T> clazz) {
        return clazz.cast(instances.computeIfAbsent(clazz, SingletonFactory::createInstance));
    }

    private static <T> T createInstance(Class<T> clazz) {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();;
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance for class: " + clazz.getName(), e);
        }
    }

    public static void main(String[] args) {
        chapter2.item3.field.Elvis fieldElvis = SingletonFactory.getInstance(chapter2.item3.field.Elvis.class);
        chapter2.item3.staticfactorymethod.Elvis staticFactoryElvis = SingletonFactory.getInstance(chapter2.item3.staticfactorymethod.Elvis.class);

        fieldElvis.leaveTheBuilding();
        staticFactoryElvis.leaveTheBuilding();

        System.out.println("Field Elvis instance hash code: " + Objects.hashCode(fieldElvis));
        System.out.println("Static Factory Elvis instance hash code: " + Objects.hashCode(staticFactoryElvis));

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();

            chapter2.item3.field.Elvis elvis1 = SingletonFactory.getInstance(chapter2.item3.field.Elvis.class);
            chapter2.item3.staticfactorymethod.Elvis elvis2 = SingletonFactory.getInstance(chapter2.item3.staticfactorymethod.Elvis.class);
            chapter2.item3.staticfactorymethod.ElvisV2 staticFactoryElvisV2 = chapter2.item3.staticfactorymethod.ElvisV2.getInstance();

            System.out.printf("%s -> Field Elvis: %s | Static Factory Elvis: %s%n | ThreadLocalElvisV2: %s%n",
                    threadName,
                    Objects.hashCode(elvis1),
                    Objects.hashCode(elvis2),
                    Objects.hashCode(staticFactoryElvisV2));
        };

        System.out.println("Threading test:");

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(task, "Thread-" + (i + 1));
            t.start();
//            Thread.ofVirtual().name("Thread-" + (i + 1)).start(task);
        }
//        Thread.sleep(10000); // Wait for daemon threads to finish
    }
}
