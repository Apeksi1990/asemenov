package ru.asemenov.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class LinkedListTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class LinkedListTest {
    /**
     * Test linked massive.
     */
    @Test
    public void whenAddElementThenReturnCorrectElement() {
        LinkedList<String> list = new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        String result = list.get(1);
        assertThat(result, is("two"));
    }
}