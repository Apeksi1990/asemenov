package ru.asemenov.Palidrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * Class Palidrom решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class Palidrom {
    /**
     * Метод проверки палидрома.
     * @param in in.
     * @return result.
     */
    boolean isPalidrom(InputStream in) {
        boolean result = true;
        String palidrom = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            palidrom = br.readLine();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        palidrom = palidrom.toLowerCase();
        char[] charStr = palidrom.toCharArray();
        for (int i = 0; i < charStr.length / 2; i++) {
            if (charStr[i] != charStr[charStr.length - i - 1]) {
                result = false;
            }
        }
        return palidrom.length() == 5 & result;
    }
}
