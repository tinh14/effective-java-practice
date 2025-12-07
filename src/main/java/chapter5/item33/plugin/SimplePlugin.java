package chapter5.item33.plugin;

public class SimplePlugin implements Plugin {

    @Override
    public void initialize() {
        System.out.println("SimplePlugin initialized!");
    }

    @Override
    public void execute() {
        System.out.println("SimplePlugin executed!");
    }

    @Override
    public void shutdown() {
        System.out.println("SimplePlugin shut down!");
    }
}
