package ru.asemenov.TestTask;
/**
 * Решение тестового задания.
 */
public class TestTask {
    /**
     * Проверка скобок.
     * @param str str.
     * @return result.
     */
    boolean equal(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' & i % 2 == 0) {
                count++;
            } else {
                count--;
            }
        }
        return count == 0;
    }
}