package chapter3.item13.cloneable;

public class ChildWithParentHasNotSuperClone extends ParentWithoutSuperClone {
    @Override
    public Object clone() {
        return super.clone();
    }
}
