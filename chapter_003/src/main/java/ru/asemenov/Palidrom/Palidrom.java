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
        boolean result = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String palidrom = br.readLine();
            palidrom = palidrom.toLowerCase();
            String reverse = revString(palidrom);
            result = palidrom.equals(reverse);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return result;
    }
    /**
     * Метод поворота слова.
     * @param str string.
     * @return result.
     */
    private String revString(String str) {
        char[] palidrom = str.toCharArray();
        char[] reverse = new char[palidrom.length];
        for (int i = 0; i < palidrom.length; i++) {
            reverse[(palidrom.length - 1) - i] = palidrom[i];
        }
        return new String(reverse);
    }
}
