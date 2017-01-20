package ru.job4j.Calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CalculatorTest решение задачи части 001 урока 2.
 * @author asemenov
 * @version 1
 */
public class CalculatorTest {
	/**
	* Сссылка на класс Calculator.
	*/
	private Calculator calc = new Calculator();
	/**
	* First number.
	*/
	public static final double TEST_NUMBER_1 = 6;
	/**
	* Second number.
	*/
	public static final double TEST_NUMBER_2 = 2;
	/**
	* First answer.
	*/
	public static final double TEST_ANSWER_1 = 8d;
	/**
	* Second answer.
	*/
	public static final double TEST_ANSWER_2 = 4d;
	/**
	* Third answer.
	*/
	public static final double TEST_ANSWER_3 = 12d;
	/**
	* Fourth answer.
	*/
	public static final double TEST_ANSWER_4 = 3d;
	/**
	* Тестирование метода сложения.
	*/
	@Test
	public void whenAddOneToOneThenTwo() {
	calc.add(TEST_NUMBER_1, TEST_NUMBER_2);
	double result = calc.getResult();
	assertThat(result, is(TEST_ANSWER_1));
	}

	/**
	* Тестирование метода вычитания.
	*/
	@Test
	public void whenSubOneToOneThenTwo() {
	calc.sub(TEST_NUMBER_1, TEST_NUMBER_2);
	double result = calc.getResult();
	assertThat(result, is(TEST_ANSWER_2));
	}

	/**
	* Тестирование метода умножения.
	*/
	@Test
	public void whenMultOneToOneThenTwo() {
	calc.mult(TEST_NUMBER_1, TEST_NUMBER_2);
	double result = calc.getResult();
	assertThat(result, is(TEST_ANSWER_3));
	}

	/**
	* Тестирование метода деления.
	*/
	@Test
	public void whenDivOneToOneThenTwo() {
	calc.div(TEST_NUMBER_1, TEST_NUMBER_2);
	double result = calc.getResult();
	assertThat(result, is(TEST_ANSWER_4));
	}
}