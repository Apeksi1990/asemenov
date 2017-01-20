package ru.job4j.TwoArray;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TwoArrayTest решение тестовой задачи части 001.
 * @author asemenov
 * @version 1
 */
public class TwoArrayTest {
	/**
	* Первый массив.
	*/
	private int[] first = new int[]{1, 2, 3, 4};
	/**
	* Второй массив.
	*/
	private int[] second = new int[]{5, 6, 7, 8};
	/**
	* Одидлаемый результат метода.
	*/
	private int[] result = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
	/**
	* Тест сложения массивов.
	*/
	@Test
	public void whenGiveTwoArrayThenGiveResultArray() {
		TwoArray twoarray = new TwoArray();
		int[] testresult = twoarray.addtwoarray(first, second);
		assertThat(testresult, is(result));
	}
}