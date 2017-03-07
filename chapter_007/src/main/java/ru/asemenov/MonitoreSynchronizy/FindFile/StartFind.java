package ru.asemenov.MonitoreSynchronizy.FindFile;

import java.io.File;
import java.util.Arrays;

public class StartFind {

    /**
     * StartFind constructor.
     * @param args text for search.
     * @throws InterruptedException exception.
     */
    private StartFind(String[] args) throws InterruptedException {
        Result result = new Result();
        System.out.println("Start find!");

        String text = Arrays.toString(args);
        text = text.substring(1, text.length()-1).replaceAll(",", "");

        File path = new File("C:/test");
        for (File file : path.listFiles()) {
            if (!result.isResult()) {
                Thread thread = new Thread(new Find(text, result, file));
                thread.start();
                thread.join();
            } else {
                break;
            }
        }
        System.out.println("Finish find!");
    }

    /**
     * Main.
     * @param args text for search.
     */
    public static void main(String[] args) throws InterruptedException {
        String[] arg = {"Super", "text", "tut"};
        new StartFind(arg);
    }
}
