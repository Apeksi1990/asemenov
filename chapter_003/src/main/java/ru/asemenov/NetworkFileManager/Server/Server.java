package ru.asemenov.NetworkFileManager.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.io.File;
/**
 * Class Server решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class Server {
    /**
     * Server port.
     */
    private final int port;
    /**
     * Home path.
     */
    private final File homePath;
    /**
     * Srver constructor.
     * @param port port.
     * @param homePath home path.
     */
    public Server(int port, String homePath) {
        this.port = port;
        this.homePath = new File(homePath);
    }
    /**
     * Start server.
     * @throws IOException exception.
     */
    public void start() throws IOException {
        System.out.println("Ждём подключения к серверу");
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             InputStream socketInStr = socket.getInputStream();
             OutputStream socketOutStr = socket.getOutputStream();
             BufferedReader read = new BufferedReader(new InputStreamReader(socketInStr))) {

            MenuServer ms = new MenuServer(socketInStr, socketOutStr, homePath);
            ms.fillActions();
            System.out.println("Подключение состоялось");
            while (true) {
                String string = read.readLine();
                System.out.println("Получена команда от клиента: " + string);
                ms.select(string);
            }
        }
    }
}
