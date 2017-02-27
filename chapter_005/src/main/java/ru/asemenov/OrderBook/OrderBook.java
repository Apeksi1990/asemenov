package ru.asemenov.OrderBook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * Class OrderBook решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class OrderBook {
    private Map<Integer, Order> allOrder = new HashMap<>();
    /**
     * Buy.
     */
    private Map<Double, Order> buy = new TreeMap<>(new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return o2.compareTo(o1);
        }
    });
    /**
     * Sell.
     */
    private Map<Double, Order> sell = new TreeMap<>();
    /**
     * Add new order.
     * @param order new.
     */
    void add(Order order) {
        allOrder.put(order.getOrderId(), order);
    }

    /**
     * Delete order.
     * @param orderId delete.
     */
    void delete(int orderId) {
        allOrder.remove(orderId);
    }

    /**
     * Print order.
     */
    void print() {
        for (Map.Entry<Integer, Order> e : allOrder.entrySet()) {
            if ("BUY".equals(e.getValue().getOperation())) {
                Order newOrder = buy.get(e.getValue().getPrice());
                if (newOrder != null) {
                    newOrder.setVolume(newOrder.getVolume() + e.getValue().getVolume());
                } else {
                    buy.put(e.getValue().getPrice(), e.getValue());
                }
            } else {
                Order newOrder = sell.get(e.getValue().getPrice());
                if (newOrder != null) {
                    newOrder.setVolume(newOrder.getVolume() + e.getValue().getVolume());
                } else {
                    sell.put(e.getValue().getPrice(), e.getValue());
                }
            }
        }

        for (Map.Entry<Double, Order> e: buy.entrySet()) {
            System.out.println("\t\t" + e.getKey() + "@" + e.getValue().getVolume());
        }

        for (Map.Entry<Double, Order> e: sell.entrySet()) {
            System.out.printf("%7s@%s\n", e.getValue().getVolume(), e.getKey());
        }
    }
}
