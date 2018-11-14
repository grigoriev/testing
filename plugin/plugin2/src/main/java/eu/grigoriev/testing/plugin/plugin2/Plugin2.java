package eu.grigoriev.testing.plugin.plugin2;

import eu.grigoriev.testing.plugin.api.Plugin;
import eu.grigoriev.testing.plugin.api.PluginAnnotation;
import eu.grigoriev.testing.plugin.api.SupportedPlugin;

@PluginAnnotation(SupportedPlugin.PLUGIN2)
public class Plugin2 implements Plugin {
    @Override
    public String perform() {
        return getClass().getName();
    }
}
