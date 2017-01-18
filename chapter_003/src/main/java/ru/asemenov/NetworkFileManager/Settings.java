package ru.asemenov.NetworkFileManager;

import java.io.InputStream;
import java.util.Properties;

public class Settings {
    private final Properties prs = new Properties();

    public void load(InputStream in) {
        try {
            this.prs.load(in);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prs.getProperty(key);
    }
}
