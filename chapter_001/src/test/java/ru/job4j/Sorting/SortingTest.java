package ru.job4j.Sorting;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SortingTest решение задачи части 001 урока 5.
 * @author asemenov
 * @version 1
 */
public class SortingTest {
	/**
	* One.
	*/
	private final int one = 1;
	/**
	* Two.
	*/
	private final int two = 2;
	/**
	* Three.
	*/
	private final int three = 3;
	/**
	* Four.
	*/
	private final int four = 4;
	/**
	* Массив для тестирования.
	*/
	private int[] values = new int[]{two, one, four, three};
	/**
	* Ожидаемый результат теста.
	*/
	private int[] valuestest = new int[]{one, two, three, four};
	/**
	* Тест сортировки массива.
	*/
	@Test
	public void whenGiveMassivThenGiveSortingMassiv() {
		Sorting sort = new Sorting();
		assertThat(sort.bubble(values), is(valuestest));
	}
}