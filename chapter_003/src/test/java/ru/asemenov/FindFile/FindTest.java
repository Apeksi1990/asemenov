package ru.asemenov.FindFile;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class FindTest решение задачи части 003 урока 3.
 * @author asemenov
 * @version 1
 */
public class FindTest {
    /**
     * Test find file.
     * @throws IOException exception.
     */
    @Test
    public void findTest() throws IOException {
        Find find = new Find(new String[]{"-d", "C:/test", "-n", "new.txt", "-f", "-o", "C:\\test\\log.txt"});
        find.start();
        File log = new File("C:\\test\\log.txt");
        RandomAccessFile read = new RandomAccessFile(log, "r");
        String result;
        result = read.readLine();
        assertThat(result, is("C:\\test\\new.txt"));
    }
}
