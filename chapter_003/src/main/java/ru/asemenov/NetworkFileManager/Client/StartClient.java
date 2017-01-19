package ru.asemenov.NetworkFileManager.Client;

import ru.asemenov.NetworkFileManager.Settings;

import java.io.IOException;
import java.io.InputStream;
/**
 * Class StartClient решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class StartClient {
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
        String inetAddress = settings.getValue("address");

        Client client = new Client(inetAddress, port);
        client.start();
    }
}