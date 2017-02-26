package ru.asemenov.OrderBook;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class ReadXML {
    /**
     * Map order.
     */
    private Map<String, OrderBook> orderBooks;

    /**
     * ReadXML constructor.
     * @param orderBooks Map.
     */
    public ReadXML(Map<String, OrderBook> orderBooks) {
        this.orderBooks = orderBooks;
    }

    /**
     * Read XML.
     * @throws FileNotFoundException exception.
     * @throws XMLStreamException exception.
     */
    void readXML(String file) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInput = XMLInputFactory.newInstance();
        InputStream in = new FileInputStream(file);
        XMLStreamReader reader = xmlInput.createXMLStreamReader(in);
        while (reader.hasNext()) {
            reader.next();
            if (reader.isStartElement()) {
                if ("AddOrder".equals(reader.getLocalName())) {
                    add(reader);
                } else if ("DeleteOrder".equals(reader.getLocalName())) {
                    delete(reader);
                }
            }
        }
    }

    private void add(XMLStreamReader reader) {
        String bookName = reader.getAttributeValue(0);
        Order order = new Order(reader.getAttributeValue(1),
                Double.valueOf(reader.getAttributeValue(2)),
                Integer.valueOf(reader.getAttributeValue(3)),
                Integer.valueOf(reader.getAttributeValue(4)));
        OrderBook orderBook = this.orderBooks.get(bookName);
        if (orderBook == null) {
            orderBook = new OrderBook();
            this.orderBooks.put(bookName, orderBook);
        }
        orderBook.add(order);

    }

    private void delete(XMLStreamReader reader) {
        OrderBook orderBook = this.orderBooks.get(reader.getAttributeValue(0));
        orderBook.delete(Integer.valueOf(reader.getAttributeValue(1)));
    }
}
