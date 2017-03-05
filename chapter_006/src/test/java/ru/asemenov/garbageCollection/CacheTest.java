package ru.asemenov.garbageCollection;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.core.Is.is;
/**
 * Class CacheTest решение задачи части 006.
 * @author asemenov
 * @version 1
 */
public class CacheTest {
    /**
     * Cache test.
     * @throws FileNotFoundException exception.
     */
    @Test
    public void whenGetFileThenReturnFileFromCache() throws FileNotFoundException {
        String separator = System.getProperty("line.separator");
        Cache cache = new Cache();
        String file = cache.request("C:\\test\\testOne.txt");
        String result = "One File Name" + separator;
        Assert.assertThat(file, is(result));
    }
}