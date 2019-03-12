package eu.grigoriev.testing.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
        log.info(getClass().getName() + " created");
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        DoubleCheckedLockingSingleton localInstance = instance;
        if (localInstance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return localInstance;
    }

    public String getSomething(String someString) {
        return someString;
    }
}
