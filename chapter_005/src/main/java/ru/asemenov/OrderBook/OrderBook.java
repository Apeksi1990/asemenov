package ru.asemenov.OrderBook;

import java.util.*;

/**
 * Class OrderBook решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class OrderBook {
    /**
     * All order.
     */
    private Map<Integer, Order> allOrder = new HashMap<>();
    /**
     * Buy order.
     */
    private Map<Double, Order> buy = new TreeMap<>(new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return o2.compareTo(o1);
        }
    });
    /**
     * Sell order.
     */
    private Map<Double, Order> sell = new TreeMap<>();

    /**
     * Add order.
     * @param order add.
     */
    void add(Order order) {
        allOrder.put(order.getOrderId(), order);
    }

    /**
     * Delete order.
     * @param orderId order.
     */
    void delete(int orderId) {
        allOrder.remove(orderId);
    }

    /**
     * Sort all order.
     */
    private void sort() {
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
    }

    /**
     * Delete order.
     */
    private void delValue() {
        Iterator<Double> buyIterator = buy.keySet().iterator();
        Iterator<Double> sellIterator = sell.keySet().iterator();

        Double nextBuy = buyIterator.next();
        Double nextSell = sellIterator.next();

        List<Double> delBuy = new ArrayList<>();
        List<Double> delSell = new ArrayList<>();

        boolean result = false;

        while (!result) {
            Order orderBuy = buy.get(nextBuy);
            Order orderSell = sell.get(nextSell);
            if (orderBuy.getPrice() >= orderSell.getPrice()) {
                if (orderBuy.getVolume() > orderSell.getVolume()) {
                    orderBuy.setVolume(orderBuy.getVolume() - orderSell.getVolume());
                    nextSell = sellIterator.next();
                    delSell.add(orderSell.getPrice());
                } else if (orderBuy.getVolume() < orderSell.getVolume()) {
                    orderSell.setVolume(orderSell.getVolume() - orderBuy.getVolume());
                    nextBuy = buyIterator.next();
                    delBuy.add(orderBuy.getPrice());
                } else {
                    buy.remove(orderBuy.getPrice());
                    sell.remove(orderSell.getPrice());
                    nextBuy = buyIterator.next();
                    nextSell = sellIterator.next();
                }
            } else {
                result = true;
            }
        }
        for (Double e : delBuy) {
            buy.remove(e);
        }
        for (Double e : delSell) {
            sell.remove(e);
        }
    }

    /**
     * Print order book.
     */
    void print() {
        sort();
        delValue();
        Iterator<Double> buyIterator = buy.keySet().iterator();
        Iterator<Double> sellIterator = sell.keySet().iterator();
        while (buyIterator.hasNext() && sellIterator.hasNext()) {

            Double nextBuy = buyIterator.next();
            Double nextSell = sellIterator.next();

            Order orderBuy = buy.get(nextBuy);
            Order orderSell = sell.get(nextSell);

            System.out.print(String.format("%7s@%s", orderBuy.getVolume(), orderBuy.getPrice()));
            System.out.println(String.format(" - %s@%s", orderSell.getPrice(), orderSell.getVolume()));
        }
    }
}
