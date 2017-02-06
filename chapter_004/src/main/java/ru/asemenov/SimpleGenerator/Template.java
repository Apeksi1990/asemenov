package ru.asemenov.SimpleGenerator;

import java.util.Map;
/**
 * Interface Template решение задачи части 004 урока 6.
 * @author asemenov
 * @version 1
 */
public interface Template {
    /**
     * Generate.
     * @param template text.
     * @param data map.
     * @return result.
     */
    String generate(String template, Map<String, String> data);
}
