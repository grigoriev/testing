package eu.grigoriev.testing.singleton;

import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;

import static org.junit.Assert.assertSame;

public class DoubleCheckedLockingSingletonTest {

    @Benchmark
    @Test
    public void testSingleton() {
        DoubleCheckedLockingSingleton instance1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton instance2 = DoubleCheckedLockingSingleton.getInstance();

        assertSame(instance1, instance2);
    }
}