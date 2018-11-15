package eu.grigoriev.testing.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        log.info(getClass().getName() + " created");
    }

    public static Singleton instance() {
        Singleton localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }

    static synchronized void reset() {
        instance = null;
    }

    public String getSomething(String someString) {
        return someString;
    }
}
