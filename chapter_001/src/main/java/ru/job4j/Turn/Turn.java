package ru.job4j.Turn;

/**
 * Class Turn решение задачи части 001 урока 5.
 * @author asemenov
 * @version 1
 */
public class Turn {
	/**
	* Метод поворота массива.
	* @param massiv vfccbd.
	* @return massiv result результат метода.
	*/
	public int[] back(int[] massiv) {
		for (int i = 0; i < massiv.length / 2; i++) {
			int back = massiv[i];
			massiv[i] = massiv[massiv.length - 1 - i];
			massiv[massiv.length - 1 - i] = back;
		}
	return massiv;
	}
}