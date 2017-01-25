package ru.asemenov.FindFile;

import java.io.File;
/**
 * Class FindBy решение задачи части 003 урока 3.
 * @author asemenov
 * @version 1
 */
public class FindBy {
    /**
     * Separator.
     */
    private String separator = System.getProperty("line.separator");
    /**
     * File name.
     */
    private String fileName;
    /**
     * String builder.
     */
    private StringBuilder sb = new StringBuilder();
    /**
     * Select find method.
     */
    private String selectFind;
    /**
     * FindBy constructor.
     * @param fileName file name.
     * @param selectFind select find method.
     */
    FindBy(String fileName, String selectFind) {
        this.fileName = fileName;
        this.selectFind = selectFind;
    }
    /**
     * Find file.
     * @param pathName path name.
     * @return result.
     */
    public String find(String pathName) {
        File dir = new File(pathName);
        File[] files = dir.listFiles();
        try {
            for (File file : files) {
                if (file.isDirectory()) {
                    find(file.getAbsolutePath());
                } else {
                    if (selectFind.equals("-f")) {
                        if (file.getName().equals(this.fileName)) {
                            sb.append(file);
                            sb.append(separator);
                        }
                    } else if (file.getName().endsWith(this.fileName)) {
                        sb.append(file);
                        sb.append(separator);
                    }
                }
            }
        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
        return sb.toString();
    }
}