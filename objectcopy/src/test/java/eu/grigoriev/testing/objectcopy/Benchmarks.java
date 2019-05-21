package eu.grigoriev.testing.objectcopy;

import org.junit.Assert;
import org.junit.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.results.BenchmarkResult;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.openjdk.jmh.runner.options.VerboseMode;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class Benchmarks {
    @Test
    public void runBenchmarks() throws Exception {
        Options options = initialize();
        Collection<RunResult> results = runBenchmark(options);
        assertOutputs(results);
    }

    private Options initialize() {
        return new OptionsBuilder()
                .include(ObjectCopyTest.class.getName() + ".*")
                .mode(Mode.AverageTime)
                .verbosity(VerboseMode.EXTRA)
                .timeUnit(TimeUnit.MILLISECONDS)
                .warmupTime(TimeValue.seconds(1))
                .measurementTime(TimeValue.milliseconds(1))
                .measurementIterations(2)
                .threads(10)
                .warmupIterations(0)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .forks(1)
                .resultFormat(ResultFormatType.JSON)
                .build();
    }

    private Collection<RunResult> runBenchmark(Options opt) throws RunnerException {
        return new Runner(opt).run();
    }

    private void assertOutputs(Collection<RunResult> runResults) {
        for (RunResult runResult : runResults) {
            for (BenchmarkResult benchmarkResult : runResult.getBenchmarkResults()) {

                Mode mode = benchmarkResult.getParams().getMode();
                double score = benchmarkResult.getPrimaryResult().getScore();
                String methodName = benchmarkResult.getPrimaryResult().getLabel();

                Assert.assertEquals("test mode is not average mode for method = " + methodName, Mode.AverageTime, mode);
//                Assert.assertTrue("benchmark score = " + score + " is higher than " + 100 + " " + benchmarkResult.getScoreUnit() + ": performance is low! ", score < 100);
            }
        }
    }
}
