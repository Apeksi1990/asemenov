package ru.asemenov.Palidrom;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class PalidromTest решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class PalidromTest {
    /**
     * Тест правильного палидрома.
     */
    @Test
    public void truePalidrom() {
        Palidrom palidrom = new Palidrom();
        InputStream in = new ByteArrayInputStream("Комок".getBytes());
        boolean result = palidrom.isPalidrom(in);
        assertThat(result, is(true));
    }
    /**
     * Тест не правильного палидрома.
     */
    @Test
    public void falsePalidrom() {
        Palidrom palidrom = new Palidrom();
        InputStream in = new ByteArrayInputStream("Супер".getBytes());
        boolean result = palidrom.isPalidrom(in);
        assertThat(result, is(false));
    }
}
