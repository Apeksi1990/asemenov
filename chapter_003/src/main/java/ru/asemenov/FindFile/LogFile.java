package ru.asemenov.FindFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * Class LogFile решение задачи части 003 урока 3.
 * @author asemenov
 * @version 1
 */
public class LogFile {
    /**
     * File log.
     */
    private File log;
    /**
     * Log constructor.
     * @param log log.
     */
    LogFile(File log) {
        this.log = log;
    }
    /**
     * Write log.
     * @param message message.
     */
    void write(String message) {
        try (PrintWriter pw = new PrintWriter(log)) {
            pw.println(message);
            pw.flush();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
    }
}
