package eu.grigoriev.testing.plugin.api;

public class PluginNotFoundException extends RuntimeException {
    public PluginNotFoundException() {
    }

    public PluginNotFoundException(String message) {
        super(message);
    }

    public PluginNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PluginNotFoundException(Throwable cause) {
        super(cause);
    }

    public PluginNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
