package chapter2.item3.field;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        ElvisV2 elvisV2 = ElvisV2.INSTANCE;
        elvisV2.leaveTheBuilding();

//      Cannot create the second instance of ElvisV2
        Constructor<ElvisV2> constructor = ElvisV2.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
