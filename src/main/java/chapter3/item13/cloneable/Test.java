package chapter3.item13.cloneable;

public class Test {

    public static void main(String[] args) {
        ChildWithParentHasNotSuperClone c1 = new ChildWithParentHasNotSuperClone();
        ChildWithParentHasSuperClone c2 = new ChildWithParentHasSuperClone();

        System.out.println("ChildWithParentHasNotSuperClone: " + (c1.getClass() ==  c1.clone().getClass()));
        System.out.println("ChildWithParentHasSuperClone: " + (c2.getClass() == c2.clone().getClass()));
    }
}
