package chapter2.item7.stack;

public class DumpStack extends AbstractStack {

    @Override
    public Object pop() {
        if (isEmpty()){
            throw new EmptyStackException("Stack is empty");
        }
        return elements[--size];
    }

}
