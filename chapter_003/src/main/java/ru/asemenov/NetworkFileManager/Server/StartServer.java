package ru.asemenov.NetworkFileManager.Server;

import java.io.IOException;
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
        ServerSettings ss = new ServerSettings();
        ss.setSettings();

        Server server = new Server(ss.getPort(), ss.getHomePath());
        server.start();
    }
}
