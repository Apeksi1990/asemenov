package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CalculateTest решение задачи части 001 урока1.
 * @author asemenov
 * @since 1
 */
public class CalculateTest {
    /**
	 *Метод для тестирования.
     */
    @Test
    public void whenAddOneToOneThenTwo() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
        Calculate.main(null);
        assertThat(out.toString(), is("Hello World" + System.getProperty("line.separator")));
    }
}