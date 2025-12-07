package chapter5.item33.plugin;

public class Test {
    public static void main(String[] args) throws Exception {
        Plugin plugin = PluginLoader.load("chapter5.item33.plugin.SimplePlugin");
        plugin.initialize();
        plugin.execute();
        plugin.shutdown();

        try {
            PluginLoader.load("chapter5.item33.plugin.InvisiblePlugin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            PluginLoader.load("chapter5.item33.plugin.MaliciousPlugin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
