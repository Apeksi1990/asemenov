package ru.asemenov.ConsoleChat;

import java.io.*;
import java.util.Objects;

public class ConsoleChat {
    /**
     * Включение ответов на сообщения.
     */
    private boolean answer = true;
    /**
     * Файл с ответами.
     */
    private File answers = new File("./answers.txt");
    /**
     * Файл логов.
     */
    private File textLog = new File("./textlog.txt");
    /**
     * Консольный чат.
     */
    public void chat() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            RandomAccessFile random = new RandomAccessFile(answers, "rw");
            RandomAccessFile writeLog = new RandomAccessFile(textLog, "rw");
            String message;
            random.writeBytes("Wow");
            do {
                message = br.readLine();
                writeLog.writeBytes(message + "\r\n");

                if (message.equals("Stop")) {
                    answer = false;
                } else if (message.equals("Continue")) {
                    answer = true;
                    continue;
                }

                if (answer & !Objects.equals(message, "Finish")) {
                    random.seek(0);
                    writeLog.writeBytes(random.readLine() + "\r\n");
                    random.seek(0);
                    System.out.println(random.readLine());
                }
            } while (!message.equals("Finish"));

            System.out.println();
            writeLog.seek(0);
            while ((message = writeLog.readLine()) != null) {
                System.out.println(message);
            }
            writeLog.close();
            textLog.delete();
            random.close();
            answers.delete();
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }

    public static void main(String[] args) {
        new ConsoleChat().chat();
    }
}
