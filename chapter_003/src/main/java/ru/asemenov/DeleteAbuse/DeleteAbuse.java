package ru.asemenov.DeleteAbuse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 * Class DeleteAbuse решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class DeleteAbuse {
    /**
     * Метод удаления лишних слов из потока.
     * @param in in.
     * @param out out.
     * @param abuse abuse.
     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            while ((line = br.readLine()) != null) {
                for (String str : abuse) {
                    if (line.contains(str)) {
                        line = line.replace(str, "");
                    }
                }
                out.write(line.getBytes());
            }
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }
}
