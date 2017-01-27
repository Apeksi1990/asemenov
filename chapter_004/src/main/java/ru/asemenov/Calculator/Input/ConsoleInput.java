package ru.asemenov.Calculator.Input;

import java.util.Scanner;

/**
 * Class ConsoleInput решение задачи части 004 урока 1.
 * @author asemenov
 * @version 1
 */
public class ConsoleInput implements Input {
	/**
     * Ввод с консоли.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Реализация.
     * @param question question.
	 * @return scanner.
     */
	public String ask(String question) {
        System.out.println(question);
        return this.scanner.next();
    }

    /**
     * Ask double.
     * @param question question.
     * @return result.
     */
    public double askDouble(String question) {
        System.out.println(question);
        return this.scanner.nextDouble();
    }
}
