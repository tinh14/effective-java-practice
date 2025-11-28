package chapter5.item26;

import java.util.ArrayList;
import java.util.List;

public class Raw {

    private static void unsafeAdd(List list, Object object) {
        list.add(object);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        unsafeAdd(list, 10);

        for (String o : list)
            System.out.println(o);
    }
}
