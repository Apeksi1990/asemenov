package ru.asemenov.SimpleGenerator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
/**
 * Class TemplateTest решение задачи части 004 урока 6.
 * @author asemenov
 * @version 1
 */
public class TemplateTest {
    /**
     * Тест замены слов.
     */
    @Test
    public void whenTakeTextWithDataShouldReplaceParamsToData() {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}, my name is ${language}.";
        String checked = "Hello, Alex, my name is Java.";
        Map<String, String> data = new HashMap<>();
        data.put("name", "Alex");
        data.put("language", "Java");
        String result = template.generate(text, data);
        Assert.assertThat(result, is(checked));
    }
    /**
     * Тест на лишний ключ.
     */
    @Test (expected = KeyException.class)
    public void whenTakeMoreDataThenKeyException() {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}, my name is ${language}.";
        String checked = "Hello, Alex, my name is Java.";
        Map<String, String> data = new HashMap<>();
        data.put("name", "Alex");
        data.put("language", "Java");
        data.put("filter", "Error");
        String result = template.generate(text, data);
        Assert.assertThat(result, is(checked));
    }
    /**
     * Тест на отсутствующий ключ.
     */
    @Test (expected = KeyException.class)
    public void whenNoDataThenKeyException() {
        Template template = new SimpleGenerator();
        String text = "Hello, ${name}, my name is ${language}.";
        String checked = "Hello, Alex, my name is Java.";
        Map<String, String> data = new HashMap<>();
        String result = template.generate(text, data);
        Assert.assertThat(result, is(checked));
    }
}