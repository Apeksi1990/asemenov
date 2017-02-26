package ru.asemenov.OrderBook;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/**
 * Class Start решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class Start {
    /**
     * Main.
     * @param args arg.
     * @throws FileNotFoundException exception.
     * @throws XMLStreamException exception.
     */
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        Map<String, OrderBook> orderBooks = new HashMap<>();
        ReadXML read = new ReadXML(orderBooks);
        read.readXML(getFile());
        for (String e : orderBooks.keySet()) {
            System.out.println(e);
            System.out.println("SELL " + " PRICE " + " BUY ");
            orderBooks.get(e).print();
        }
    }
    /**
     * Get file.
     * @return file.
     */
    private static String getFile() {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")) {
            settings.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return settings.getValue("file");
    }
}
