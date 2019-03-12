package eu.grigoriev.testing.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingletonWithHolder {
    private static class Holder {
        private static final SingletonWithHolder instance = new SingletonWithHolder();
    }

    private SingletonWithHolder() {
        log.info(getClass().getName() + " created");
    }

    public static SingletonWithHolder getInstance() {
        return Holder.instance;
    }

    public String getSomething(String someString) {
        return someString;
    }
}
