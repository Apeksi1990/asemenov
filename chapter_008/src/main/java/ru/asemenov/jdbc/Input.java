package ru.asemenov.jdbc;
/**
 * Interface Input решение задачи части 002 урока 3.
 * @author asemenov
 * @version 1
 */
public interface Input {
	/**
     * Метод ask.
     * @param question question.
	 * @return return.
     */
    String ask(String question);
	/**
	 * Int ask.
	 * @param question question.
	 * @param range range.
	 * @return return.
	 */
	int ask(String question, int[] range);
}
