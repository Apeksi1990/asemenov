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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String palidrom = br.readLine();
            palidrom = palidrom.toLowerCase();
            String rotation = new StringBuffer(palidrom).reverse().toString();
            return palidrom.length() == 5 & palidrom.equals(rotation);
        } catch (IOException exc) {
            System.out.println(exc);
        }
        return false;
    }
}
