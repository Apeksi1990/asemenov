package ru.asemenov.jdbc;

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
	/**
     * Реализация.
     * @param question question.
     * @param range range.
     * @return key.
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
    }
}
