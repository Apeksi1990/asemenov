package ru.asemenov.NetworkFileManager;

import java.io.InputStream;
import java.util.Properties;
/**
 * Class Settings решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class Settings {
    /**
     * Properties.
     */
    private final Properties prs = new Properties();
    /**
     * Properties load.
     * @param in in.
     */
    public void load(InputStream in) {
        try {
            this.prs.load(in);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    /**
     * Get Properties value.
     * @param key key.
     * @return result
     */
    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
}
