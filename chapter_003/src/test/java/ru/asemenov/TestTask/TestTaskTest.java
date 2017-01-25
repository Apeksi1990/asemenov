package ru.asemenov.TestTask;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class TestTaskTest решение задачи части 003.
 * @author asemenov
 * @version 1
 */
public class TestTaskTest {
    /**
     * Test delete sequence.
     */
    @Test
    public void testDelSequence() {
        TestTask tt = new TestTask();
        int[] massive = new int[]{1,2,3,4,4,5,5,5,6,7,8,3,3,4,5,1};
        int[] result = new int[]{1,2,3,6,7,8,4,5,1};
        massive = tt.del(massive);
        assertThat(massive, is(result));
    }
}
