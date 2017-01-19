package ru.asemenov.NetworkFileManager.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.InputStreamReader;
/**
 * Class Client решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class Client {
    /**
     * Server address.
     */
    private final String serverAddress;
    /**
     * Port server.
     */
    private final int port;
    /**
     * Client constructor.
     * @param serverAddress server address.
     * @param serverPort server port.
     */
    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.port = serverPort;
    }
    /**
     * Start client.
     * @throws IOException exception.
     */
    public void start() throws IOException {
        System.out.println("Подключение к серверу: " + serverAddress);
        InetAddress inetAddress = InetAddress.getByName(serverAddress);
        try (Socket socket = new Socket(inetAddress, port);
             InputStream socketInStr = socket.getInputStream();
             OutputStream socketOutStr = socket.getOutputStream();
             BufferedReader readConsole = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socketInStr));
             PrintWriter writer = new PrintWriter(socketOutStr, true)) {

            MoveFile moveFile = new MoveFile(socketInStr, socketOutStr);
            System.out.println("Подключение состоялось.");
            System.out.println("Помощь help");
            while (true) {
                String message = readConsole.readLine();
                String[] splitMessage = message.split(" ");
                if (splitMessage[0].equals("upload")) {
                    moveFile.upload(splitMessage[1], splitMessage[2]);
                } else if (splitMessage[0].equals("download")) {
                    moveFile.download(splitMessage[1], splitMessage[2]);
                } else {
                    writer.println(message);
                    String answer = reader.readLine();
                    System.out.println(answer);
                    while (reader.ready()) {
                        System.out.println(reader.readLine());
                    }
                }
            }
        }
    }
}


