package ru.asemenov.OrderBook;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
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
        long start = System.currentTimeMillis();
        Map<String, OrderBook> orderBooks = new HashMap<>();
        ReadXML read = new ReadXML(orderBooks);
        read.readXML("C:\\orders.xml");
        for (String e : orderBooks.keySet()) {
            System.out.println("Book name: " + e);
            System.out.println("\tBUY" + "\t\tPRICE" + "\tSELL");
            orderBooks.get(e).print();
            System.out.println();
        }
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
}
