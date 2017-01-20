package ru.job4j.Calculator;

/**
 * Class Calculator решение задачи части 001 урока 2.
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
}