package ru.asemenov.XO;

import java.util.Scanner;

/**
 * Class ConsoleInput решение задачи части 004.
 * @author asemenov
 * @version 1
 */
public class ConsoleInput implements Input {
    /**
     * Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ask.
     * @param question message.
     * @return scanner.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * Int ask.
     * @param question message.
     * @param range number.
     * @return key.
     */
	public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new KeyException("Error range");
        }
    }
}
