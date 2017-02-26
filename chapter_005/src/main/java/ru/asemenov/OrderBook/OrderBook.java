package ru.asemenov.OrderBook;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/**
 * Class OrderBook решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class OrderBook {
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
        if ("BUY".equals(order.getOperation())) {
            Order newOrder = buy.get(order.getPrice());
            if (newOrder != null) {
                newOrder.setVolume(newOrder.getVolume() + order.getVolume());
            } else {
                buy.put(order.getPrice(), order);
            }

        } else {
            Order newOrder = sell.get(order.getPrice());
            if (newOrder != null) {
                newOrder.setVolume(newOrder.getVolume() + order.getVolume());
            } else {
                sell.put(order.getPrice(), order);
            }
        }
    }

    /**
     * Delete order.
     * @param orderId delete.
     * @return boolean.
     */
    boolean delete(int orderId) {
        for (Map.Entry<Double, Order> e: buy.entrySet()) {
            if (e.getValue().getOrderId() == orderId) {
                buy.remove(e.getKey());
                return true;
            }
        }
        for (Map.Entry<Double, Order> e: sell.entrySet()) {
            if (e.getValue().getOrderId() == orderId) {
                buy.remove(e.getKey());
                return true;
            }
        }
        return false;
    }

    /**
     * Print order.
     */
    void print() {
        for (Map.Entry<Double, Order> e: buy.entrySet()) {
            System.out.println("\t\t" + e.getKey() + "@" + e.getValue().getVolume());
        }

        for (Map.Entry<Double, Order> e: sell.entrySet()) {
            System.out.println(e.getValue().getVolume() + "@" +  e.getKey());
        }
    }
}
