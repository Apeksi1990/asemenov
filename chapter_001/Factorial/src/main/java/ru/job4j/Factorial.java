package ru.job4j;

/**
 * Class Factorial решение задачи части 001 урока 4.
 * @author asemenov
 * @version 1
 */
public class Factorial {
	/**
	* Метод нахождения факториала.
	* @param number число факториала.
	* @return result результат метода.
	*/
	public int fact(int number) {
		int result = 1;
		for (int i = 1; i <= number; i++) {
			result = result * i;
		}
		return result;
	}
	/**
	* Метод нахождения факториала рекурсией.
	* @param number число факториала.
	* @return результат метода.
	*/
	public int recursion(int number) {
		return (number != 1) ? number * recursion(number - 1) : 1;
	}
}