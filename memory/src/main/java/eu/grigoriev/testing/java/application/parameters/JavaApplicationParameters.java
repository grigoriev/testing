package eu.grigoriev.testing.java.application.parameters;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.util.*;

@Slf4j
public class JavaApplicationParameters {
    public static void main(String[] args) {
        log.info("Xms = " + (Runtime.getRuntime().totalMemory() / 1024 / 1024) + " Mb");
        log.info("Xmx = " + (Runtime.getRuntime().maxMemory() / 1024 / 1024) + " Mb");

        String classPath = ManagementFactory.getRuntimeMXBean().getClassPath();
        log.info("classPath = " + classPath);

        List<String> vmArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
        log.info("vmArgs = " + vmArgs);

        List<String> vmParameters = Arrays.asList(args);
        log.info("vmParameters = " + vmParameters);
    }
}
