package ru.asemenov.NetworkFileManager.Server;

import ru.asemenov.NetworkFileManager.Settings;

import java.io.IOException;
import java.io.InputStream;
/**
 * Class ServerSettings решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class ServerSettings {
    /**
     * Port.
     */
    private int port;
    /**
     * Home path.
     */
    private String homePath;
    /**
     * Set server settings.
     */
    public void setSettings() {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")) {
            settings.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        port = Integer.parseInt(settings.getValue("port"));
        homePath = settings.getValue("home.path");
    }
    /**
     * Get port.
     * @return port.
     */
    public int getPort() {
        return port;
    }
    /**
     * Get home path.
     * @return home path.
     */
    public String getHomePath() {
        return homePath;
    }
}
