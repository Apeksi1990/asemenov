package ru.asemenov.ByteStream;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ByteStreamTest решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class ByteStreamTest {
    /**
     * Тест с чётным числом.
     */
    @Test
    public void trueNumber() {
        ByteStream bs = new ByteStream();
        InputStream in = new ByteArrayInputStream("10".getBytes());
        boolean result = bs.isNumber(in);
        assertThat(result, is(true));
    }
    /**
     * Тест с нечетным числом.
     */
    @Test
    public void falseNumber() {
        ByteStream bs = new ByteStream();
        InputStream in = new ByteArrayInputStream("9".getBytes());
        boolean result = bs.isNumber(in);
        assertThat(result, is(false));
    }
    /**
     * Тест с буквой.
     */
    @Test
    public void falseChar() {
        ByteStream bs = new ByteStream();
        InputStream in = new ByteArrayInputStream("A".getBytes());
        boolean result = bs.isNumber(in);
        assertThat(result, is(false));
    }
}
