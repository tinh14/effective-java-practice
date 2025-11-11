package chapter3.item13.cloneable;

public class ParentWithoutSuperClone implements Cloneable {
    @Override
    public Object clone() {
        return new ParentWithSuperClone();
    }
}
