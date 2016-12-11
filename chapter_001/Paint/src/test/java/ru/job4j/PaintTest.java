package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class PaintTest решение задачи части 001 урока 4.
 * @author asemenov
 * @version 1
 */
public class PaintTest {
	/**
	* Тестирование построения пирамиды.
	*/
	@Test
    public void whenGiveHeightThenViewPiramid() {
        Paint print = new Paint();
        final int h = 2;
        assertThat(print.pyramid(h).toString(), is(" ^ " + System.getProperty("line.separator") + "^ ^ " + System.getProperty("line.separator")));
    }
}
