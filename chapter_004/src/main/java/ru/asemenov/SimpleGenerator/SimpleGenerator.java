package ru.asemenov.SimpleGenerator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class SimpleGenerator решение задачи части 004 урока 6.
 * @author asemenov
 * @version 1
 */
public class SimpleGenerator implements Template {
    /**
     * Replace text.
     * @param template text.
     * @param data map.
     * @return result.
     */
    @Override
    public String generate(String template, Map<String, String> data) {
        check(template, data);
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String text = "\\$\\{" + entry.getKey() + "\\}";
            Pattern pattern = Pattern.compile(text);
            Matcher matcher = pattern.matcher(template);
            if (matcher.find()) {
                template = template.replaceAll(text, entry.getValue());
            } else {
                throw new KeyException("Key not found");
            }
        }
        return template;
    }
    /**
     * Check exception.
     * @param template text.
     * @param data map.
     */
    private void check(String template, Map<String, String> data) {
        for (String key : data.keySet()) {
            if (!template.contains(key)) {
                throw new KeyException("Excess key");
            }
        }
    }
}
