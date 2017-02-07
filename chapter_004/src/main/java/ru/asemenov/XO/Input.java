package ru.asemenov.XO;
/**
 * Interface Input решение задачи части 004 урока 4.
 * @author asemenov
 * @version 1
 */
public interface Input {
    String ask(String question);
    int ask(String question, int[] range);
}
