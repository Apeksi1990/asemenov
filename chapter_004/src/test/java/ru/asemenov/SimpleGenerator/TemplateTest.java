package ru.asemenov.SimpleGenerator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;

public class TemplateTest {
    @Test
    public void generate() {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}.";
        String checked = "Hello, Alex.";
        Map<String, String> data = new HashMap<>();
        data.put("${name}","Alex");
        data.put("${login}","Logan");
        String result = template.generate(text, data);
        Assert.assertThat(result, is(checked));
    }

}