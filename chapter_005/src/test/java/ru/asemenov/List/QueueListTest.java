package ru.asemenov.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class QueueListTest  решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class QueueListTest {
    /**
     * Queue test.
     */
    @Test
    public void whenAddElementThenReturnFirstElement() {
        QueueList<String> list = new QueueList<>();
        list.push("one");
        list.push("two");
        list.push("three");
        assertThat(list.poll(), is("one"));
    }
}