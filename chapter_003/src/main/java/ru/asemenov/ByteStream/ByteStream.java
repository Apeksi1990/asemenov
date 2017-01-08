package ru.asemenov.ByteStream;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Class ByteStream решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class ByteStream {
    /**
     * Метод проверяющий четное число.
     * @param in in.
     * @return result.
     */
    boolean isNumber(InputStream in) {
        boolean result = false;
        try {
            Scanner sc = new Scanner(in);
            int number = sc.nextInt();
            if (number % 2 == 0) {
                result = true;
            }
        } catch (InputMismatchException ime) {
            System.out.println(ime);
        }
        return result;
    }
}