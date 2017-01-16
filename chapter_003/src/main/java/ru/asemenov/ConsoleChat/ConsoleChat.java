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
     * String STOP.
     */
    private final String STOP = "Stop";
    /**
     * String CONTINUE.
     */
    private final String CONTINUE = "Continue";
    /**
     * String FINISH.
     */
    private final String FINISH = "Finish";
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
                if (STOP.equals(message)) {
                    answer = false;
                } else if (CONTINUE.equals(message)) {
                    answer = true;
                } else if (answer & !FINISH.equals(message)) {
                    message = chatBot.bot();
                    System.out.println(message);
                    writeLog.writeBytes(message);
                    writeLog.writeBytes(separator);
                }
            } while (!FINISH.equals(message));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
