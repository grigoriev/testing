package eu.grigoriev.testing.singleton;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SingletonTest {

    @Test
    public void testSingleton() {
        Singleton instance1 = Singleton.instance();
        Singleton instance2 = Singleton.instance();

        assertSame(instance1, instance2);
    }
}