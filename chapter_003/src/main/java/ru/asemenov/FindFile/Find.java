package ru.asemenov.FindFile;

import java.io.File;
/**
 * Class Find решение задачи части 003 урока 3.
 * @author asemenov
 * @version 1
 */
public class Find {
    /**
     * Args.
     */
    private String[] args;
    /**
     * Result.
     */
    private String result;
    /**
     * Find constructor.
     * @param args args.
     */
    Find(String[] args) {
        this.args = args;
    }
    /**
     * Start.
     */
    void start() {
        CheckRequest check = new CheckRequest(this.args);
        if (check.check()) {
            LogFile logFile = new LogFile(new File(check.getLogFile()));
            FindBy fb = new FindBy(check.getFileName(), check.getSelectFind());
            result = fb.find(check.getDirName());
            logFile.write(result);
        } else {
            System.out.println(check.help().toString());
        }
    }
}
