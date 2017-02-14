package ru.asemenov.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListTest {
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