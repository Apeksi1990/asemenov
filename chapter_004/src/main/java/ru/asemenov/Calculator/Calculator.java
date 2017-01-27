package ru.asemenov.Calculator;

/**
 * Class Calculator решение задачи части 004 урока 1.
 * @author asemenov
 * @version 1
 */
public class Calculator {
	/**
	* переменная результата.
	*/
	private double result;
	/**
	* Метод сложения двух чисел.
	*@param first первое значение.
	*@param second второе значение.
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}

	/**
	* Метод вычитания двух чисел.
	*@param first первое значение.
	*@param second второе значение.
	*/
	public void sub(double first, double second) {
		this.result = first - second;
	}

	/**
	* Метод умножения двух чисел.
	*@param first первое значение.
	*@param second второе значение.
	*/
	public void mult(double first, double second) {
		this.result = first * second;
	}

	/**
	* Метод деления двух чисел.
	*@param first первое значение.
	*@param second второе значение.
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	* Метод возврата результата операций.
	*@return result возвращает результат операции
	*/
	public double getResult() {
		return this.result;
	}

	/**
	 * Sin.
	 * @param value value.
	 */
	public void sin(double value) {
		result = Math.sin(Math.toRadians(value));
	}
	/**
	 * Cos.
	 * @param value value.
	 */
	public void cos(double value) {
		result = Math.cos(Math.toRadians(value));
	}
	/**
	 * Tan.
	 * @param value value.
	 */
	public void tan(double value) {
		result = Math.tan(Math.toRadians(value));
	}
}