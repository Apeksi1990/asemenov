package ru.asemenov.ConsoleChat;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class ConsoleChatTest решение задачи части 003 урока 1.
 * @author asemenov
 * @version 1
 */
public class ConsoleChatTest {
    /**
     * Тест сортировки.
     */
    @Test
    public void fileSort() {
        File answers = new File("Answers.txt");
        File textLog = new File("Textlog.txt");
        Input stubInput = new StubInput(new String[]{"Privet", "Finish"});
        try (RandomAccessFile randomAnswer = new RandomAccessFile(answers, "rw")) {
            randomAnswer.writeBytes("testAnswer");
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        ConsoleChat chat = new ConsoleChat(answers, textLog, stubInput);
        chat.chat();
        ArrayList<String> result = new ArrayList<>();
        result.add("Privet");
        result.add("testAnswer");
        result.add("Finish");
        ArrayList<String> resultLog = new ArrayList<>();
        try (RandomAccessFile readLog = new RandomAccessFile(textLog, "r")) {
            String line;
            while ((line = readLog.readLine()) != null) {
                resultLog.add(line);
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        boolean finish = result.equals(resultLog);

        assertThat(finish, is(true));
        answers.delete();
        textLog.delete();
    }
}
