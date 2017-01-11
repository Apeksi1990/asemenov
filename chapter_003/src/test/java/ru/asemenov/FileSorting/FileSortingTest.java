package ru.asemenov.FileSorting;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class FileSortingTest решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class FileSortingTest {
    /**
     * Тест проверки сортировки.
     */
    @Test
    public void fileSort() {
        FileSorting fs = new FileSorting();
        String separator = System.getProperty("line.separator");
        boolean result = true;
        File start = new File("Start.txt");
        File finish = new File("Finish.txt");
        try (RandomAccessFile write = new RandomAccessFile(start, "rw");
             RandomAccessFile writeFinish = new RandomAccessFile(finish, "rw");) {
            write.writeBytes("55555" + separator);
            write.writeBytes("22" + separator);
            write.writeBytes("4444" + separator);
            write.writeBytes("333" + separator);
            write.writeBytes("1" + separator);
            write.writeBytes("333" + separator);
            fs.sort(start, finish);
            String line;
            String lastLine = "";
            while ((line = writeFinish.readLine()) != null) {
                if (lastLine.length() > line.length()) {
                    result = false;
                }
                lastLine = line;
            }
        } catch (IOException exc) {
            System.out.println(exc);
        }
        assertThat(result, is(true));
        start.delete();
        finish.delete();
    }
}
