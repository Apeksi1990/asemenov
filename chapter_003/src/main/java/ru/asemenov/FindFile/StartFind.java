package ru.asemenov.FindFile;
/**
 * Class StartFind решение задачи части 003 урока 3.
 * @author asemenov
 * @version 1
 */
public class StartFind {
    /**
     * Main.
     * @param args args.
     */
    public static void main(String[] args) {
        String[] arg = {"-d", "C:/test", "-n", "new.txt", "-f", "-o", "log.txt"};
        Find ff = new Find(arg);
        ff.start();
    }
}
