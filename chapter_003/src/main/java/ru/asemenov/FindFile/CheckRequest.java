package ru.asemenov.FindFile;
/**
 * Class CheckRequest решение задачи части 003 урока 3.
 * @author asemenov
 * @version 1
 */
public class CheckRequest {
    /**
     * Separator.
     */
    private String separator = System.getProperty("line.separator");
    /**
     * Args.
     */
    private String[] args;
    /**
     * Directory name.
     */
    private String dirName;
    /**
     * File name.
     */
    private String fileName;
    /**
     * Search method.
     */
    private String selectFind;
    /**
     * File log.
     */
    private String logFile;
    /**
     * Get log file.
     * @return log file.
     */
    public String getLogFile() {
        return logFile;
    }
    /**
     * Get search method.
     * @return search method.
     */
    public String getSelectFind() {
        return selectFind;
    }
    /**
     * Get file name.
     * @return file name.
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * Get directory name.
     * @return directory name.
     */
    public String getDirName() {
        return dirName;
    }
    /**
     * Checkrequest constructor.
     * @param args args.
     */
    CheckRequest(String[] args) {
        this.args = args;
    }
    /**
     * Set parameters.
     */
    private void setParam() {
        this.dirName = this.args[1];
        this.fileName = this.args[3];
        this.selectFind = this.args[4];
        this.logFile = this.args[6];
    }
    /**
     * Result check.
     * @return result.
     */
    public Boolean check() {
        boolean result = false;
        if (this.args.length == 7) {
            if (this.args[0].equals("-d") & this.args[2].equals("-n") & (this.args[4].equals("-m") | this.args[4].equals("-f")) & this.args[5].equals("-o")) {
                result = true;
                setParam();
            }
        }
        return result;
    }
    /**
     * Help.
     * @return help.
     */
    StringBuilder help() {
        return new StringBuilder()
                .append("Общая схема запроса: java -jar find.jar -d c:/ -n *.txt -m -o log.txt").append(separator)
                .append("-d - директория в которая начинать поиск.").append(separator)
                .append("-n - имя файл или маска.").append(separator)
                .append("-m - искать по макс, либо -f - полное совпадение имени.").append(separator)
                .append("-o - результат записать в файл");
    }
}
