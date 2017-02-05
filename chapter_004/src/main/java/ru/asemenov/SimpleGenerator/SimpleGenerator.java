package ru.asemenov.SimpleGenerator;

import java.util.Map;

public class SimpleGenerator implements Template {
    @Override
    public String generate(String template, Map<String, String> data) {
        check(template, data);
        return "Hello, Alex.";
    }

    public void check(String template, Map<String, String> data) {
        for (String key : data.keySet()) {
            if (!template.contains(key)) {
                throw new KeyException("Excess key");
            }
        }

    }
}
