package ru.asemenov.SimpleGenerator;

import java.util.Map;

public interface Template {
    String generate(String template, Map<String, String> data);
}
