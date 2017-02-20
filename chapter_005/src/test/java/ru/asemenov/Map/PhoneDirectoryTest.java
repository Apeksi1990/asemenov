package ru.asemenov.Map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;

/**
 * Class PhoneDirectoryTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class PhoneDirectoryTest {
    /**
     * Directory test.
     */
    @Test
    public void whenAddPhoneThenReturnCorrectPhone() {
        Directory<Integer, String> directory = new PhoneDirectory<>(10);
        directory.insert(123456, "Alex");
        directory.insert(654321, "Olya");
        directory.insert(192837, "Putin");
        Iterator<String> iterator = directory.iterator();
        iterator.next();
        iterator.next();
        String result = iterator.next();
        Assert.assertThat(result, is("Putin"));
    }
}