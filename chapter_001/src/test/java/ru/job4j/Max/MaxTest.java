package ru.job4j.Max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class MaxTest решение задачи части 001 урока 3.
 * @author asemenov
 * @version 1
 */
public class MaxTest {
	/**
	* First namber.
	*/
	private final int one = 1;
	/**
	* Second namber.
	*/
    private final int two = 2;
	/**
	* Third namber.
	*/
    private final int three = 3;
	/**
	* ссылка на класс Max.
	*/
    private Max max = new Max();

	/**
	* Тест нахождения максимального из двух чисел.
	*/
    @Test
    public void whenOneTwoThenMax() {
        int result = max.max(one, two);
        assertThat(result, is(two));
    }

	/**
	* Тест нахождения максимального из трех чисел.
	*/
    @Test
    public void whenOneTwoThreeThenMax() {
        int result = max.max(one, two, three);
        assertThat(result, is(three));
    }
}