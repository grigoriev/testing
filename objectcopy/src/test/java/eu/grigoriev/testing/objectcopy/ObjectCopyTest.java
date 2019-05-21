package eu.grigoriev.testing.objectcopy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ObjectCopyTest {

    @Benchmark
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

    @Benchmark
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

    @Benchmark
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