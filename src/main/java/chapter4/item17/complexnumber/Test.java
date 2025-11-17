package chapter4.item17.complexnumber;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        ComplexNumber c1 = ComplexNumber.valueOf(1.0, 5.0);
        ComplexNumber c2 = ComplexNumber.valueOf(1.0, 1.0);
        ComplexNumber c3 = ComplexNumber.valueOf(1.0, 5.0);

        System.out.println("C1:" + c1);
        System.out.println("C2:" + c2);
        System.out.println("C3:" + c3);

        System.out.println("C1's real part: " + c1.realPart());
        System.out.println("C1's imaginary part: " + c1.imaginaryPart() + "i");

        System.out.println("C1 equals C2:" + c1.equals(c2));
        System.out.println("C1 equals C3:" + c1.equals(c3));

        System.out.println("C1 plus C2: " + c1.plus(c2));
        System.out.println("C1 minus C2: " + c1.minus(c2));
        System.out.println("C1 times C2: " + c1.times(c2));
        System.out.println("C1 dividedBy C2: " + c1.dividedBy(c2));

        Set<ComplexNumber> hashSet = new HashSet<>();
        hashSet.add(c1);
        hashSet.add(c2);
        hashSet.add(c3);
        hashSet.add(ComplexNumber.i());
        System.out.println("Hashset: " + hashSet);

        Set<ComplexNumber> treeSet = new TreeSet<>();
        treeSet.add(c1);
        treeSet.add(c2);
        treeSet.add(c3);
        treeSet.add(ComplexNumber.i());
        System.out.println("Treeset: " + treeSet);
    }
}
