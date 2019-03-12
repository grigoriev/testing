package eu.grigoriev.testing.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
        log.info(getClass().getName() + " created");
    }

    public static EagerInitializedSingleton getInstance() {
        return instance;
    }

    public String getSomething(String someString) {
        return someString;
    }
}
