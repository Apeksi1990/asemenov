package ru.asemenov.MonitoreSynchronizy.FindFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Class Find решение задачи части 007.
 * @author asemenov
 * @version 1
 */
public class Find implements Runnable {
    /**
     * Text for search.
     */
    private String find;
    /**
     * Result.
     */
    private Result result;
    /**
     * File.
     */
    private File file;

    /**
     * Find constructor.
     * @param find find.
     * @param result result.
     * @param file file.
     */
    public Find(String find, Result result, File file) {
        this.find = find;
        this.result = result;
        this.file = file;
    }

    /**
     * Override run.
     */
    @Override
    public void run() {
        try {
            if (this.file.isDirectory()) {
                find(this.file, this.find);
            } else {
                scanner(this.file, find);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find.
     * @param path path.
     * @param text text.
     * @throws FileNotFoundException exception.
     */
    private void find(File path, String text) throws FileNotFoundException {
        try {
            for (File file : path.listFiles()) {
                if (!this.result.isResult()) {
                    if (file.isDirectory()) {
                        find(file, text);
                    } else {
                        scanner(file, text);
                    }
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scanner file.
     * @param file file.
     * @param text text.
     * @throws FileNotFoundException exception.
     */
    private void scanner(File file, String text) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String txt = scanner.nextLine();
            if (txt.contains(text)) {
                System.out.println("Text <" + text + "> found");
                System.out.println("File <" + file.getName() + ">");
                this.result.setResult();
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
