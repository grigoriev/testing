package eu.grigoriev.testing.plugin.plugin1;

import eu.grigoriev.testing.plugin.api.Plugin;
import eu.grigoriev.testing.plugin.api.PluginAnnotation;
import eu.grigoriev.testing.plugin.api.SupportedPlugin;

@PluginAnnotation(SupportedPlugin.PLUGIN1)
public class Plugin1 implements Plugin {
    @Override
    public String perform() {
        return getClass().getName();
    }
}
