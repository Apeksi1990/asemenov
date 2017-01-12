package ru.asemenov.ConsoleChat;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * Class StartChat решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class StartChat {
    /**
     * Start Chat.
     * @param args args.
     */
    public static void main(String[] args) {
        File answers = new File("Answers.txt");
        File textLog = new File("Textlog.txt");
        Input input = new ConsoleInput();
        Input stubInput = new StubInput(new String[]{"Privet", "Kak dela", "Super", "Finish"});

        try (RandomAccessFile randomAnswer = new RandomAccessFile(answers, "rw");
             RandomAccessFile textFile = new RandomAccessFile(textLog, "rw")) {
            randomAnswer.writeBytes("testAnswerOne" + "\r\n");
            randomAnswer.writeBytes("testAnswerTwo" + "\r\n");
            new ConsoleChat(answers, textLog, input).chat();

            System.out.println();
            String line;
            textFile.seek(0);
            while ((line = textFile.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        answers.delete();
        textLog.delete();
    }
}
