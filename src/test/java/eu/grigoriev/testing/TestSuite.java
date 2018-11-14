package eu.grigoriev.testing;

import eu.grigoriev.testing.objectcopy.ObjectCopyTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ObjectCopyTest.class
})
public class TestSuite {
}
