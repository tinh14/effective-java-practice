package chapter8.item52.setlist;

import java.util.ArrayList;
import java.util.List;

public class SetList {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            list1.add(i);
            list2.add(i);
        }

        for (int i = 0; i < 3; i++) {
            list1.remove(i);
            list2.remove(Integer.valueOf(i));
        }
        System.out.println(list1 + " " + list2);
    }
}
