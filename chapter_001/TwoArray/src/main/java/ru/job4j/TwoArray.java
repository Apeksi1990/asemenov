package ru.job4j;

/**
 * Class TwoArray решение тестовой задачи части 001.
 * @author asemenov
 * @version 1
 */
public class TwoArray {
	/**
	* Метод сложения двух массивов.
	* @param first первый массив.
	* @param second второй массив.
	* @return result результат метода.
	*/
	public static int[] addtwoarray(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int n = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                result[n] = first[i];
                i++;
            } else {
                result[n] = second[j];
                j++;
            }
            n++;
        }
        while (i < first.length) {
            result[n] = first[i];
            n++;
            i++;
        }
        while (j < second.length) {
            result[n] = second[j];
            n++;
            j++;
        }
        return result;
	}
}