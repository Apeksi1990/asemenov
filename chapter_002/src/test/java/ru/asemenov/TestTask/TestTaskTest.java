package ru.asemenov.TestTask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TestTaskTest решение тестовой задачи.
 * @author asemenov
 * @version 1
 */
public class TestTaskTest {
    /**
     * Тест верное кол-во скобок.
     */
    @Test
    public final void trueTestTask() {
        TestTask test = new TestTask();
        String result = "()()()";
        assertThat(test.equal(result), is(true));
    }
    /**
     * Не верное кол-во скобок.
     */
    @Test
    public final void falseTestTask() {
        TestTask test = new TestTask();
        String result = "())";
        assertThat(test.equal(result), is(false));
    }
}
