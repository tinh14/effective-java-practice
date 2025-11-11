package chapter3.item13.cloneable;

public class ChildWithParentHasSuperClone extends ParentWithSuperClone {
    @Override
    public Object clone() {
        return super.clone();
    }
}
