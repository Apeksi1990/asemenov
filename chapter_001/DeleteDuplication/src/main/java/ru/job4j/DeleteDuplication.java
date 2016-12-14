package ru.job4j;

import java.util.Arrays;
/**
 * Class DeleteDuplication решение задачи части 001 урока 5.
 * @author asemenov
 * @version 1
 */
public class DeleteDuplication {
	/**
	* Метод нахождения повторений.
	* @param values массив с дубликатами.
	* @return result результат метода.
	*/
	public String[] deldup(String[] values) {
		int n = 0;
		for (int i = 0; i < values.length; i++) {
			String in = values[i];
			for (int j = i + 1; j < values.length; j++) {
				if (in != null && in.equals(values[j])) {
					values[j] = null;
					n++;
				}
			}
		}
        endnull(values, n);
        String[] result;
        result = Arrays.copyOf(values, values.length - n);
        return result;
    }
	/**
	* Метод перестановки null в конец массива.
	* @param values массив с дубликатами.
	* @param n кол-во дубликатов.
	* @return values результат метода.
	*/
    public String[] endnull(String[] values, int n) {
        for (int i = 0; i < values.length - n; i++) {
            if (values[i] == null) {
                for (int j = values.length - 1; j >= 0; j--) {
                    if (values[j] != null) {
                        values[i] = values[j];
                        values[j] = null;
                        break;
                    }
                }
            }
        }
        return values;
    }
}