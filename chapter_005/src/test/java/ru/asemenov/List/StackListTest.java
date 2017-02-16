package ru.asemenov.List;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
/**
 * Class StackListTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class StackListTest {
    /**
     * Stack test.
     */
    @Test
    public void whenAddElementThenReturnLastElement() {
        StackList<String> list = new StackList<>();
        list.push("one");
        list.push("two");
        list.push("three");
        Assert.assertThat(list.pop(), is("three"));
    }
}
