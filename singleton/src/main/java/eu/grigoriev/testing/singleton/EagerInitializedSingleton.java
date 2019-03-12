package eu.grigoriev.testing.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
        log.info(getClass().getName() + " created");
    }

    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }

    public String getSomething(String someString) {
        return someString;
    }
}
