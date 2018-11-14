package eu.grigoriev.testing.plugin.app;

import eu.grigoriev.testing.plugin.api.Plugin;
import eu.grigoriev.testing.plugin.api.PluginFactory;
import eu.grigoriev.testing.plugin.api.SupportedPlugin;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
    public static void main(String[] args) {
        PluginFactory pluginFactory = new PluginFactory();
        Plugin plugin1 = pluginFactory.getPlugin(SupportedPlugin.PLUGIN1);
        Plugin plugin2 = pluginFactory.getPlugin(SupportedPlugin.PLUGIN2);

        String result1 = plugin1.perform();
        String result2 = plugin2.perform();

        log.info(result1);
        log.info(result2);
    }
}
