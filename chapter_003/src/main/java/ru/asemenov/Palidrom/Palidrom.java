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
        String palidrom = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            palidrom = br.readLine();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        palidrom = palidrom.toLowerCase();
        char[] charStr = palidrom.toCharArray();
        String reverse = "";
        for (int i = charStr.length - 1; i >= 0; i--) {
            reverse = String.format("%s%s", reverse, palidrom.charAt(i));
        }
        return palidrom.length() == 5 & palidrom.equals(reverse);
    }
}
