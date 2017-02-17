package ru.asemenov.Set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class LinkedSetTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class LinkedSetTest {
    /**
     * Linked set test.
     */
    @Test
    public void whenAddSameElementThenReturnUniqueElement() {
        LinkedSet<String> set = new LinkedSet<>();
        set.add("one");
        set.add("two");
        set.add("one");
        set.add("zero");
        Iterator<String> iterator = set.iterator();
        iterator.next();
        iterator.next();
        String result = iterator.next();
        assertThat(result, is("zero"));
    }
}