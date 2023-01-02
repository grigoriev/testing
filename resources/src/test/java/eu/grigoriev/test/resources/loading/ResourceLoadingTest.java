package eu.grigoriev.test.resources.loading;

import java.net.URL;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResourceLoadingTest {

    @Test
    public void givenAbsoluteResourcePath_whenGetResource_thenReturnResource() {
        URL resourceAbsolutePath = ResourceLoadingTest.class
                .getResource("/test.txt");
        assertNotNull(resourceAbsolutePath);
    }

    @Test
    public void givenRelativeResourcePath_whenGetResource_thenReturnResource() {
        URL resourceRelativePath = ResourceLoadingTest.class
                .getResource("test.txt");
        assertNull(resourceRelativePath);
    }

    @Test
    public void givenAbsoluteResourcePath_whenGetClassLoaderGetResource_thenReturnResource() {
        URL resourceAbsolutePath = ResourceLoadingTest.class.getClassLoader()
                .getResource("/test.txt");
        assertNull(resourceAbsolutePath);
    }

    @Test
    public void givenRelativeResourcePath_whenGetClassLoaderGetResource_thenReturnNull() {
        URL resourceRelativePath = ResourceLoadingTest.class.getClassLoader()
                .getResource("test.txt");
        assertNotNull(resourceRelativePath);
    }
}
