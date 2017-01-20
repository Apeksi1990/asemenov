package ru.job4j.Counter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CounterTest решение задачи части 001 урока 4.
 * @author asemenov
 * @since 1
 */
public class CounterTest {
	/**
	* Тестовый результат.
	*/
	private final int testResult = 28;
	/**
	* Начало диапозона.
	*/
	private final int start = 4;
	/**
	* Конец диапозона.
	*/
	private final int finish = 10;
	/**
	* Тест на сложение чисел в диапозоне.
	*/
	@Test
	public void whenGiveRangeThenAddRange() {
	Counter counter = new Counter();
	assertThat(counter.add(start, finish), is(testResult));
	}
}