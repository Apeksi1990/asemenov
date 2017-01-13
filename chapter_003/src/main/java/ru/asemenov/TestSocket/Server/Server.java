package ru.asemenov.TestSocket.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class Server.
 * @author asemenov
 * @version 1
 */
public class Server {
    /**
     * Start Server.
     * @param args args.
     */
    public static void main(String[] args) {
        int port = 5000;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Ждём подключения к серверу");
            Socket socket = serverSocket.accept();
            System.out.println("Подключение состоялось");

            InputStream socketInStr = socket.getInputStream();
            OutputStream socketOutStr = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStr);
            DataOutputStream out = new DataOutputStream(socketOutStr);

            String string = null;
            while (true) {
                string = in.readUTF();
                System.out.println("Мы получии следующее сообщение: " + string);
                System.out.println("Отправка обратно");
                out.writeUTF(string);
                out.flush();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
