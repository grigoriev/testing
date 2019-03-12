package eu.grigoriev.testing.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnDemandHolderSingleton {
    private static class Holder {
        private static final OnDemandHolderSingleton INSTANCE = new OnDemandHolderSingleton();
    }

    private OnDemandHolderSingleton() {
        log.info(getClass().getName() + " created");
    }

    public static OnDemandHolderSingleton getInstance() {
        return Holder.INSTANCE;
    }

    public String getSomething(String someString) {
        return someString;
    }
}
