package ru.asemenov.OrderBook;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class OrderBook {
    /**
     * Buy.
     */
    private Map<Integer, Order> buy = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    /**
     * Sell.
     */
    private Map<Integer, Order> sell = new TreeMap<>();
    /**
     * Add new order.
     * @param order new.
     */
    void add(Order order) {
        if ("BUY".equals(order.getOperation())) {
            buy.put(order.getOrderId(), order);
        } else {
            sell.put(order.getOrderId(), order);
        }
    }

    /**
     * Delete order.
     * @param orderId delete.
     */
    void delete(int orderId) {
        if (buy.get(orderId) != null) {
            buy.remove(orderId);
        } else {
            sell.remove(orderId);
        }
    }
}
