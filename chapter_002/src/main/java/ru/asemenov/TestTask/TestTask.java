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
        for (char a : chars) {
            if (a == '(') {
                count++;
            }
        }
        return count == chars.length / 2 && chars.length % 2 == 0;
    }
}