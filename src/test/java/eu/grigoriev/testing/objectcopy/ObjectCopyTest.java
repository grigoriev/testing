package eu.grigoriev.testing.objectcopy;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class ObjectCopyTest {
    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    @BenchmarkOptions(benchmarkRounds = 20000, warmupRounds = 0)
    @Test
    public void deepCopy() throws CloneNotSupportedException {
        Parent parent = new Parent(new Child1(new SubChild1(1)), new Child2(2));

        Parent parentCopy = new ObjectCopy().deepCopy(parent);

        assertNotSame(parent.getChild1(), parentCopy.getChild1());
        assertNotSame(parent.getChild1().getSubChild1(), parentCopy.getChild1().getSubChild1());
        assertNotSame(parent.getChild2(), parentCopy.getChild2());
        assertEquals(parent, parentCopy);
        assertNotSame(parent, parentCopy);
    }

    @BenchmarkOptions(benchmarkRounds = 20000, warmupRounds = 0)
    @Test
    public void deepCopyWithSerializationUtils() {
        Parent parent = new Parent(new Child1(new SubChild1(1)), new Child2(2));

        Parent parentCopy = new ObjectCopy().deepCopyWithSerializationUtils(parent);

        assertNotSame(parent.getChild1(), parentCopy.getChild1());
        assertNotSame(parent.getChild1().getSubChild1(), parentCopy.getChild1().getSubChild1());
        assertNotSame(parent.getChild2(), parentCopy.getChild2());
        assertEquals(parent, parentCopy);
        assertNotSame(parent, parentCopy);
    }

    @BenchmarkOptions(benchmarkRounds = 20000, warmupRounds = 0)
    @Test
    public void shallowCopy() {
        Parent parent = new Parent(new Child1(new SubChild1(1)), new Child2(2));

        Parent parentCopy = new ObjectCopy().shallowCopy(parent);

        assertSame(parent.getChild1(), parentCopy.getChild1());
        assertSame(parent.getChild1().getSubChild1(), parentCopy.getChild1().getSubChild1());
        assertSame(parent.getChild2(), parentCopy.getChild2());
        assertEquals(parent, parentCopy);
        assertNotSame(parent, parentCopy);
    }
}