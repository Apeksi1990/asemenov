package ru.asemenov.NetworkFileManager.Client;

import java.io.IOException;
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
        ClientSettings cs = new ClientSettings();
        cs.setSettings();

        Client client = new Client(cs.getInetAddress(), cs.getPort());
        client.start();
    }
}