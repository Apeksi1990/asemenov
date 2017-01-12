package ru.asemenov.ConsoleChat;

import java.util.Scanner;
/**
 * Class ConsoleInput решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class ConsoleInput implements Input {
    /**
     * Scanner console.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Message Input.
     * @return message.
     */
    public String message() {
        return scanner.nextLine();
    }
}
