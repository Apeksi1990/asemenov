package ru.job4j;

/**
 * Class Counter решение задачи части 001 урока 4.
 * @author asemenov
 * @since 1
 */
public class Counter {
	/**
	* Результат сложения.
	*/
	private int result;
	/**
	* Метод сложения чисел в диапозоне.
	*@return result результат сложения.
	*@param start начало диапозона.
	*@param finish конец диапозона.
	*/
	public int add(int start, int finish) {
	for (int i = start; i <= finish; i++) {
		if (i % 2 == 0) {
			result = result + i;
		}
	}
	return result;
	}
}