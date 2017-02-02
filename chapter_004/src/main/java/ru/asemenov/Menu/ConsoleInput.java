package ru.asemenov.Menu;

import java.util.Scanner;

/**
 * Class ConsoleInput решение задачи части 004 урока 4.
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
     * @param question question.
     * @return scanner.
     */
	public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
