package ru.asemenov.jdbc;
/**
 * class ValidateInput решение задачи части 002 урока 5.
 * @author asemenov
 * @version 1
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Обработка исключений.
     * @param question question.
     * @param range range.
     * @return value.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            }
        } while (invalid);
        return value;
    }
}