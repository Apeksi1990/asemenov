package ru.asemenov.Tracker;

import java.util.Scanner;
/**
 * Class ConsoleInput решение задачи части 002 урока 3.
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
        return scanner.nextLine();
    }
}
