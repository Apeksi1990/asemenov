package ru.job4j;

/**
 * Class TestTask решение задачи части 001 тестовое задание.
 * @author asemenov
 * @version 1
 */
public class TestTask {
	/**
	* Метод проверки строк.
	* @param origin первая строка.
	* @param sub вторая строка.
	* @return результат метода.
	*/
	public boolean strequals(String origin, String sub) {
		char[] first = origin.toCharArray();
		char[] second = sub.toCharArray();
		for (int i = 0; i < first.length; i++) {
			if (first[i] == second[0] && second.length <= first.length) {
				int n = 0;
				for (int j = 0; j < second.length; j++) {
					if (second[j] == first[i + j]) {
						n++;
					}
				}
				if (n == second.length) {
					return true;
				}
			}
		}
		return false;
	}
}