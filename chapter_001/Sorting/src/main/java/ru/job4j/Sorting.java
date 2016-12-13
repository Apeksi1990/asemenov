package ru.job4j;

/**
 * Class Sorting решение задачи части 001 урока 5.
 * @author asemenov
 * @version 1
 */
public class Sorting {
	/**
	* Метод сортировки массива.
	* @param values массив.
	* @return values результат метода.
	*/
	public int[] bubble(int[] values) {
		for (int i = 1; i < values.length; i++) {
			for (int j = values.length - 1; j >= i; j--) {
			if (values[j - 1] > values[j]) {
				int h = values[j - 1];
				values[j - 1] = values[j];
				values[j] = h;
				}
			}
		}
	return values;
	}
}