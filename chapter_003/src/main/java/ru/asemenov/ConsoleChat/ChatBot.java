package ru.asemenov.ConsoleChat;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
/**
 * Class ChatBot решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class ChatBot {
    /**
     * Файл ответов.
     */
    private File answers;
    /**
     * Конструктор ChatBot.
     * @param answers answers.
     */
    ChatBot(File answers) {
        this.answers = answers;
    }
    /**
     * Ответы.
     */
    private ArrayList<String> answer = new ArrayList<>();
    /**
     * Кол-во ответов.
     */
    private int count = 0;

    /**
     * Метод чтения файла ответов.
     */
    void readAnswers() {
        String line;
        try (RandomAccessFile randomAnswer = new RandomAccessFile(answers, "rw")) {
            while ((line = randomAnswer.readLine()) != null) {
                answer.add(line);
                count++;
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    /**
     * Chat Bot.
     * @return string.
     */
    String bot() {
        String line = "";
        try {
            int random = (int) (Math.random() * count);
            line = answer.get(random);
        } catch (IndexOutOfBoundsException ibx) {
            ibx.printStackTrace();
        }

        return line;
    }
}
