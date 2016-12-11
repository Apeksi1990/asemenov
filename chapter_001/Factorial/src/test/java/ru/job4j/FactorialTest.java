package ru.job4j;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class FactorialTest решение задачи части 001 урока 4.
 * @author asemenov
 * @version 1
 */
public class FactorialTest {
	/**
	* Число для которого нужно найти факториал.
	*/
	private final int number = 3;
	/**
	* Тестовый результат метода.
	*/
	private final int result = 6;
	/**
	* Тест нахождения факториала.
	*/
	@Test
	public void whenGiveRangeThenAddRange() {
		Factorial factorial = new Factorial();
		assertThat(factorial.fact(number), is(result));
	}
	/**
	* Тест нахождения факториала рекурсией.
	*/
	@Test
	public void whenGiveRangeThenAddRangeRecursion() {
		Factorial factorial = new Factorial();
		assertThat(factorial.recursion(number), is(result));
	}
}