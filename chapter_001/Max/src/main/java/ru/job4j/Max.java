package ru.job4j;

/**
 * Class Max решение задачи части 001 урока 3.
 * @author asemenov
 * @version 1
 */
public class Max {
	/**
	* Метод нахождения максимального из двух чисел.
	*@param first первое число
	*@param second второе число
	*@return максимальное число
	*/
    public int max(int first, int second) {
        return first > second ? first : second;
    }

	/**
	* Метод нахождения максимального из трех чисел.
	*@param first первое число
	*@param second второе число
	*@param third третье число
	*@return максимальное число
	*/
    public int max(int first, int second, int third) {
        int result = first > second ? first : second;
        return result > third ? result : third;
    }
}