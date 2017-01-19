package ru.asemenov.NetworkFileManager.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.InputStreamReader;
/**
 * Class MoveFile решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class MoveFile {
    /**
     * InputStream.
     */
    private InputStream in;
    /**
     * OutputStream.
     */
    private OutputStream out;

    /**
     * MoveFile constructor.
     * @param in InputStream.
     * @param out OutputStream.
     */
    MoveFile(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    /**
     * Upload file.
     * @param fileClient file on the client.
     * @param fileServer file on the server.
     * @throws IOException exception.
     */
    void upload(String fileClient, String fileServer) throws IOException {
        File file = new File(fileClient);
        PrintWriter writer = new PrintWriter(this.out, true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.in));
        writer.println(String.format("upload %s", fileServer));
        if (reader.readLine().equals("File created")) {
            writer.println(file.length());
            byte[] bytes = new byte[16 * 1024];
            int count;
            try (FileInputStream in = new FileInputStream(file)) {
                while ((count = in.read(bytes)) != -1) {
                    this.out.write(bytes, 0, count);
                    this.out.flush();
                }
                System.out.println("Передача файла завершилась");
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    /**
     * Download file.
     * @param fileClient file on the client.
     * @param fileServer file on the server.
     * @throws IOException exception.
     */
    void download(String fileServer, String fileClient) throws IOException {
        File file = new File(fileClient);
        PrintWriter writer = new PrintWriter(this.out, true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.in));
        writer.println(String.format("download %s", fileServer));
        int fileSize = Integer.parseInt(reader.readLine());
        try (FileOutputStream out = new FileOutputStream(file)) {
            byte[] bytes = new byte[16 * 1024];
            int count;
            while (fileSize > 0) {
                count = in.read(bytes);
                out.write(bytes, 0, count);
                out.flush();
                fileSize -= count;
            }
            System.out.println("Загрузка файла завершилась");
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
