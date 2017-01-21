package ru.asemenov.NetworkFileManager.Client;

import ru.asemenov.NetworkFileManager.Settings;

import java.io.IOException;
import java.io.InputStream;
/**
 * Class ClientSettings решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class ClientSettings {
    /**
     * Port.
     */
    private int port;
    /**
     * Inet Address.
     */
    private String inetAddress;
    /**
     * Set client settings.
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
        inetAddress = settings.getValue("address");
    }
    /**
     * Get port.
     * @return port.
     */
    public int getPort() {
        return port;
    }
    /**
     * Get inet address.
     * @return inet address.
     */
    public String getInetAddress() {
        return inetAddress;
    }
}
