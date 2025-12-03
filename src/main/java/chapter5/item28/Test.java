package chapter5.item28;

import java.util.List;

public class Test {
    public static void main(String[] args) {

/*
        -- Arrays are covariant --
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; -> Fails at runtime, throws ArrayStoreException

        -- Generic types are invariant --
        List<Object> objectList = new ArrayList<Long>(); -> Compiles error

        -- a parameterized type array creation --
        List<String>[] stringList = new List<String>[1]; -> Compiles error

        -- Assuming the generic array creation is legal --
        List<Integer> intList = List.of(42);
        Object[] objects = stringList;
        objects[0] = intList;
        String s = stringList[0].get(0); -> Throws ClassCastException
 */
        // Better Chooser
        List<Integer> list = List.of(1, 2 ,3, 4);
        BetterChooser<Integer> chooser = new BetterChooser<>(list);
//        String string = chooser.choose(); // Cannot compile
        Number number = chooser.choose();
        System.out.println("BetterChooser: " + number);

        SlightlyBadChooser<Integer> slightlyBadChooser = new SlightlyBadChooser<>(list);
//        String string = slightlyBadChooser.choose(); // Cannot compile
        number = slightlyBadChooser.choose();
        System.out.println("SlightlyBadChooser: " + number);

        BadChooser badChooser = new BadChooser(list);
        String string = (String) badChooser.choose(); // throws ClassCastException
    }

}
