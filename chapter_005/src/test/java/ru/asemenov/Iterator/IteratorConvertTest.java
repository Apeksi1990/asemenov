package ru.asemenov.Iterator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
/**
 * Class IteratorConvertTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class IteratorConvertTest {
    /**
     * Test iterator.
     */
    @Test
    public void whenThreeIteratorThenOneIterator() {
        Iterator<Integer> iteratorOne = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        Iterator<Integer> iteratorTwo = Arrays.asList(0, 9, 8, 7, 5).iterator();
        Iterator<Integer> iteratorThree = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();
        Iterator<Iterator<Integer>> iterators = Arrays.asList(iteratorOne, iteratorTwo, iteratorThree).iterator();

        Convert iteratorConvert = new IteratorConvert();
        Iterator<Integer> iterator = iteratorConvert.convert(iterators);
        ArrayList<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        int[] massive = new int[]{4, 2, 0, 4, 6, 4, 9, 0, 9, 8, 7, 5, 1, 3, 5, 6, 7, 0, 9, 8, 4};
        ArrayList<Integer> allIterator = new ArrayList<>();
        for (int i : massive) {
            allIterator.add(i);
        }
        Assert.assertThat(result, is(allIterator));
    }

}