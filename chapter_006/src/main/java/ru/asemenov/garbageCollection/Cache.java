package ru.asemenov.garbageCollection;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Class Cache решение задачи части 006.
 * @author asemenov
 * @version 1
 */
public class Cache {
    /**
     * Separator.
     */
    private String separator = System.getProperty("line.separator");
    /**
     * Cache.
     */
    private Map<String, SoftReference<String>> cache;

    /**
     * Cache constructor.
     */
    Cache() {
        this.cache = new HashMap<>();
    }

    /**
     * Request get file.
     * @param fileName file.
     * @return String.
     * @throws FileNotFoundException exception.
     */
    String request(String fileName) throws FileNotFoundException {
        SoftReference<String> file = this.cache.get(fileName);
        if (file == null) {
            file = new SoftReference<>(readFile(fileName));
            this.cache.put(fileName, file);
        }
        return file.get();
    }

    /**
     * Read file.
     * @param fileName file.
     * @return String.
     * @throws FileNotFoundException exception.
     */
    private String readFile(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            sb.append(scanner.nextLine());
            sb.append(this.separator);
        }
        return sb.toString();
    }
}
