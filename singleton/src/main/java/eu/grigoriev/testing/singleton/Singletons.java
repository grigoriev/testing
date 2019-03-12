package eu.grigoriev.testing.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Singletons {
    public static void main(String[] args) {
        log.info(EagerInitializedSingleton.getInstance().getSomething("EagerInitializedSingleton"));
        log.info(DoubleCheckedLockingSingleton.getInstance().getSomething("DoubleCheckedLockingSingleton"));
        log.info(SingletonWithHolder.getInstance().getSomething("SingletonWithHolder"));
    }
}
