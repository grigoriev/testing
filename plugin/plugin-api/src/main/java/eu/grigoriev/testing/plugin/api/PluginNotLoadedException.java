package eu.grigoriev.testing.plugin.api;

public class PluginNotLoadedException extends RuntimeException {
    public PluginNotLoadedException() {
    }

    public PluginNotLoadedException(String message) {
        super(message);
    }

    public PluginNotLoadedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PluginNotLoadedException(Throwable cause) {
        super(cause);
    }

    public PluginNotLoadedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
