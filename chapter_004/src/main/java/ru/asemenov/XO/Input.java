package ru.asemenov.XO;
/**
 * Interface Input решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public interface Input {
    /**
     * Ask.
     * @param question message.
     * @return ask.
     */
    String ask(String question);

    /**
     * Int ask.
     * @param question message.
     * @param range number.
     * @return ask.
     */
    int ask(String question, int[] range);
}
