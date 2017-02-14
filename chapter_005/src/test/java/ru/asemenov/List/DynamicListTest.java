package ru.asemenov.List;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class DynamicListTest {
    @Test
    public void whenAddStingThenReturnThis() {
        DynamicList<String> list = new DynamicList<>(2);
        list.add("testOne");
        list.add("testTwo");
        list.add("testThree");
        list.add("testFour");
        String result = list.get(3);
        Assert.assertThat(result, is("testFour"));
    }
}