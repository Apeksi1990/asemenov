package ru.asemenov.Calculator.Input;
/**
 * Interface Input решение задачи части 004 урока 1.
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
     * Ask double.
     * @param question question.
     * @return result.
     */
    double askDouble(String question);
}
