package ru.job4j.TestTask;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TestTaskTest решение задачи части 001 тестовое задание.
 * @author asemenov
 * @version 1
 */
public class TestTaskTest {
	/**
	* Тест проверки подстроки.
	*/
	@Test
	public void whenGiveTwoStringThenStringEqualsString() {
		TestTask test = new TestTask();
		String origin = "Привет новый мир";
		String sub = "новый мир";
		boolean result = test.strequals(origin, sub);
		assertThat(result, is(true));
	}
}