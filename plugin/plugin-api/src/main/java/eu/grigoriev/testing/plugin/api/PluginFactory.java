package eu.grigoriev.testing.plugin.api;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public class PluginFactory {
    public Plugin getPlugin(SupportedPlugin supportedPlugin) {
        return loadAnnotatedClass("eu.grigoriev.testing.plugin", PluginAnnotation.class, supportedPlugin);
    }

    private Plugin loadAnnotatedClass(String prefix, Class<PluginAnnotation> annotationClass, SupportedPlugin supportedPlugin) {
        return new Reflections(prefix).getTypesAnnotatedWith(annotationClass).stream()
                .filter(c -> c.getAnnotation(annotationClass).value() == supportedPlugin)
                .findFirst()
                .map(this::createPluginObject)
                .orElseThrow(PluginNotFoundException::new);
    }

    private Plugin createPluginObject(Class<?> clazz) {
        try {
            return (Plugin) clazz.getConstructor().newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new PluginNotLoadedException(e);
        }
    }
}
