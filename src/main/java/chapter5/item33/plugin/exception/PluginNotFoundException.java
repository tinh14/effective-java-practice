package chapter5.item33.plugin.exception;

public class PluginNotFoundException extends RuntimeException {
    public PluginNotFoundException(String message) {
        super(message);
    }
}
