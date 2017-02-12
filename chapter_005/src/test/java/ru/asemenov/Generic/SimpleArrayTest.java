package ru.asemenov.Generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class SimpleArrayTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class SimpleArrayTest {
    /**
     * Add and Get test.
     */
    @Test
    public void whenCreateConstructorThenReturnSameType() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("test");
        String result = simpleArray.get(0);
        assertThat(result, is("test"));
    }

    /**
     * Update test.
     */
    @Test
    public void whenUpdateValueThenReturnNewValue() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("oldValue");
        simpleArray.update(0, "newValue");
        String result = simpleArray.get(0);
        assertThat(result, is("newValue"));
    }

    /**
     * Delete test.
     */
    @Test
    public void whenDeleteValueThenReturnNull() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("test");
        simpleArray.delete(0);
        String result = simpleArray.get(0);
        assertThat(result, is((String) null));
    }
}