package chapter5.item33.plugin;

import chapter5.item33.plugin.exception.InvalidPluginException;
import chapter5.item33.plugin.exception.PluginNotFoundException;

public class PluginLoader {
    public static Plugin load(String typeName) {
        try {
            Class<?> rawPluginType = Class.forName(typeName);
            Class<? extends Plugin> pluginType = rawPluginType.asSubclass(Plugin.class);
            return pluginType.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new PluginNotFoundException("Plugin " + typeName + " not found");
        } catch (Exception e) {
            throw new InvalidPluginException("Plugin " + typeName + " is invalid");
        }
    }
}

