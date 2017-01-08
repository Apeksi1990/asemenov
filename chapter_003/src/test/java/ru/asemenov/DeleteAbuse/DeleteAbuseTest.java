package ru.asemenov.DeleteAbuse;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class DeleteAbuseTest решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class DeleteAbuseTest {
    /**
     * Тест удаления лишних слов из потока.
     */
    @Test
    public void delAbuse() {
        DeleteAbuse delete = new DeleteAbuse();
        String test = "Hello world, great day";
        String[] abuse = {"world", "day"};
        String result = "Hello , great ";
        InputStream in = new ByteArrayInputStream(test.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        delete.dropAbuses(in, out, abuse);
        assertThat(out.toString(), is(result));
    }
}
