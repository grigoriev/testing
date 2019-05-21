package eu.grigoriev.testing.singleton;

import org.junit.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

public class Benchmarks {

    @Test
    public void runBenchmarks() throws Exception {
        Options options = new OptionsBuilder()
                .include(DoubleCheckedLockingSingletonTest.class.getName() + ".*")
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.MILLISECONDS)
                .measurementTime(TimeValue.milliseconds(1))
                .measurementIterations(2)
                .warmupIterations(0)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .forks(1)
                .resultFormat(ResultFormatType.JSON)
                .build();

        new Runner(options).run();
    }
}
