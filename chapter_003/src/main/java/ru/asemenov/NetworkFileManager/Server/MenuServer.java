package ru.asemenov.NetworkFileManager.Server;

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
 * Class MenuServer решение задачи части 003 урока 2.
 * @author asemenov
 * @version 1
 */
public class MenuServer {
    /**
     * Separator.
     */
    private String separator = System.getProperty("line.separator");
    /**
     * InputStream.
     */
    private InputStream in;
    /**
     * OutputStream.
     */
    private OutputStream out;
    /**
     * Current Path.
     */
    private File currentPath;
    /**
     * PrintWriter.
     */
    private PrintWriter write;
    /**
     * Position.
     */
    private int position = 0;
    /**
     * Actions.
     */
    private BaseAction[] actions = new BaseAction[5];
    /**
     * Help.
     */
    private final String help = "help";
    /**
     * MenuServer constructor.
     * @param in InputStream.
     * @param out OutputStream.
     * @param homePath Home path.
     */
    MenuServer(InputStream in, OutputStream out, File homePath) {
        this.in = in;
        this.out = out;
        this.currentPath = homePath;
        write = new PrintWriter(out, true);
    }
    /**
     * Fill actions.
     */
    void fillActions() {
        this.actions[position++] = new ShowCurrentPath();
        this.actions[position++] = new InDirectory();
        this.actions[position++] = new OutDirectory();
        this.actions[position++] = new Download();
        this.actions[position++] = new Upload();
    }
    /**
     * Select action.
     * @param string string.
     * @throws IOException exception.
     */
    void select(String string) throws IOException {
        String[] message = string.split(" ");
        BaseAction action = checkKey(message[0]);
        if (action != null) {
            action.execute(message);
        } else if (help.equals(string)) {
            show();
        } else {
            write.println("Команда не найдена (введите help)");
        }
    }
    /**
     * Check key actions.
     * @param message message.
     * @return result.
     */
    private BaseAction checkKey(String message) {
        BaseAction result = null;
        for (BaseAction action : this.actions) {
            if (message.equals(action.key())) {
                result = action;
            }
        }
        return result;
    }
    /**
     * Show help.
     */
    private void show() {
        StringBuilder sb = new StringBuilder();
        for (BaseAction action : this.actions) {
            sb.append(action.info());
            sb.append(separator);
        }
        write.println(sb.toString());
    }
    /**
     * Show Current Path.
     */
    private class ShowCurrentPath extends BaseAction {
        /**
         * Key.
         * @return dir.
         */
        public String key() {
            return "dir";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Показать текущую директорию: dir";
        }
        /**
         * Execute.
         * @param message message.
         * @throws IOException exception.
         */
        public void execute(String[] message) throws IOException {
            StringBuilder sb = new StringBuilder();
            for (File file : currentPath.listFiles()) {
                sb.append(file.getName());
                sb.append(separator);
            }
            write.println(sb.toString());
        }
    }
    /**
     * Move in directory.
     */
    private class InDirectory extends BaseAction {
        /**
         * Key.
         * @return cd.
         */
        public String key() {
            return "cd";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Для перемещения в каталог ввести: cd <требуемый каталог>";
        }
        /**
         * Execute.
         * @param message message.
         * @throws IOException exception.
         */
        public void execute(String[] message) throws IOException {
            boolean result = false;
            if (message.length > 1) {
                for (File file : currentPath.listFiles()) {
                    if (message[1].equals(file.getName())) {
                        currentPath = new File(String.format("%s\\%s", currentPath.getPath(), message[1]));
                        result = true;
                    }
                }
            }
            if (result) {
                write.println("Пермещение в каталог " + currentPath.getPath());
            } else {
                write.println("Не верно задан каталог");
            }
        }
    }
    /**
     * Move out directory.
     */
    private class OutDirectory extends BaseAction {
        /**
         * Key.
         * @return cd..
         */
        public String key() {
            return "cd..";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Для перемещения в родительский каталог ввести: cd..";
        }
        /**
         * Execute.
         * @param message message.
         * @throws IOException exception.
         */
        public void execute(String[] message) throws IOException {
            if (currentPath.getPath().length() <= 3) {
                write.println("Нельзя переместиться ниже");
            } else {
                currentPath = new File(currentPath.getParent());
                write.println("Пермещение в каталог " + currentPath.getPath());
            }
        }
    }
    /**
     * Download to the client.
     */
    private class Download extends BaseAction {
        /**
         * Key.
         * @return download.
         */
        public String key() {
            return "download";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Для скачивания файла на клиент ввести: download <путь_сервера> <путь_клиента>";
        }
        /**
         * Execute.
         * @param message message.
         * @throws IOException exception.
         */
        public void execute(String[] message) throws IOException {
            File file = new File(message[1]);
            write.println(file.length());
            byte[] bytes = new byte[16 * 1024];
            int count;
            try (FileInputStream in = new FileInputStream(file)) {
                while ((count = in.read(bytes)) != -1) {
                    out.write(bytes, 0, count);
                    out.flush();
                }
                System.out.println("Передача файла завершилась");
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
    /**
     * Upload to the server.
     */
    private class Upload extends BaseAction {
        /**
         * Key.
         * @return upload.
         */
        public String key() {
            return "upload";
        }
        /**
         * Info.
         * @return info.
         */
        public String info() {
            return "Для загрузки файла на сервер ввести: upload <путь_клиента> <путь_сервера>";
        }
        /**
         * Execute.
         * @param message message.
         * @throws IOException exception.
         */
        public void execute(String[] message) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            File file = new File(message[1]);
            write.println("File created");
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
                System.out.println("Загрузка файла на сервер завершилась");
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }
}
