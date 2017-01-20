package ru.job4j.Rotation;

/**
 * Class Rotation решение задачи части 001 урока 5.
 * @author asemenov
 * @version 1
 */
public class Rotation {
	/**
	* Метод поворота квадратного массива.
	* @param values массив.
	* @return values результат метода.
	*/
	public int[][] rotation(int[][] values) {
		int[][] result = new int[2][2];
		int y = values.length - 1;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				result[j][y] = values[i][j];
			}
			y--;
		}
	return result;
	}
}