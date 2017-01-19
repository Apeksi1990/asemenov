package ru.asemenov.NetworkFileManager.Server;

import ru.asemenov.NetworkFileManager.Settings;

import java.io.IOException;
import java.io.InputStream;
/**
 * Class StartServer решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class StartServer {
    /**
     * Main.
     * @param args args.
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")) {
            settings.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int port = Integer.parseInt(settings.getValue("port"));
        String homePath = settings.getValue("home.path");

        Server server = new Server(port, homePath);
        server.start();
    }
}
