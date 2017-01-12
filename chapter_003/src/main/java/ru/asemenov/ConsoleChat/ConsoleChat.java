package ru.asemenov.ConsoleChat;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * Class ConsoleChat решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class ConsoleChat {
    /**
     * Separator.
     */
    private String separator = System.getProperty("line.separator");
    /**
     * Включение ответов на сообщения.
     */
    private boolean answer = true;
    /**
     * Файл с ответами.
     */
    private File answers;
    /**
     * Файл логов.
     */
    private File textLog;
    /**
     * Input.
     */
    private Input input;
    /**
     * Конструктор.
     * @param answers answer.
     * @param textLog textLog.
     * @param input input.
     */
    ConsoleChat(File answers, File textLog, Input input) {
        this.answers = answers;
        this.textLog = textLog;
        this.input = input;
    }
    /**
     * Консольный чат.
     */
    void chat() {
        try (RandomAccessFile writeLog = new RandomAccessFile(textLog, "rw")) {
            ChatBot chatBot = new ChatBot(this.answers);
            chatBot.readAnswers();
            String message;
            do {
                message = input.message();
                System.out.println(message);
                writeLog.writeBytes(message);
                writeLog.writeBytes(separator);
                if (message.equals("Stop")) {
                    answer = false;
                } else if (message.equals("Continue")) {
                    answer = true;
                } else if (answer & !message.equals("Finish")) {
                    message = chatBot.bot();
                    System.out.println(message);
                    writeLog.writeBytes(message);
                    writeLog.writeBytes(separator);
                }
            } while (!message.equals("Finish"));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
