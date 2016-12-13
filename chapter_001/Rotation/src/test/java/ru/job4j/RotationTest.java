package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class RotationTest решение задачи части 001 урока 5.
 * @author asemenov
 * @version 1
 */
public class RotationTest {
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
	private int[][] values = new int[][]{{one, two}, {three, four}};
	/**
	* Ожидаемый результат теста.
	*/
	private int[][] valuestest = new int[][]{{three, one}, {four, two}};
	/**
	* Тест сортировки массива.
	*/
	@Test
	public void whenGiveMassivThenGiveSortingMassiv() {
		Rotation rotation = new Rotation();
		assertThat(rotation.rotation(values), is(valuestest));
	}
}