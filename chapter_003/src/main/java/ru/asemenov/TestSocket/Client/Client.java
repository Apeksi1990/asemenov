package ru.asemenov.TestSocket.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class Client.
 * @author asemenov
 * @version 1
 */
public class Client {
    /**
     * Start Client.
     * @param args args.
     */
    public static void main(String[] args) {
        int servPort = 5000;

        String interAdress = "127.0.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(interAdress);
            System.out.println("Подключение к серверу: " + servPort);
            Socket socket = new Socket(inetAddress, servPort);

            InputStream socketInStr = socket.getInputStream();
            OutputStream socketOutStr = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketInStr);
            DataOutputStream out = new DataOutputStream(socketOutStr);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = null;

            System.out.println("Введите сообщение:");

            while (true) {
                string = reader.readLine();
                out.writeUTF(string);
                out.flush();
                string = in.readUTF();
                System.out.println("Сервер прислал ответ: " + string);
                System.out.println("Введите следующее сообщение:");
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
