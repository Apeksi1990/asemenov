package ru.asemenov.OrderBook;

public class Order {
    /**
     * Operation.
     */
    private String operation;
    /**
     * Price.
     */
    private double price;
    /**
     * Volume.
     */
    private int volume;
    /**
     * Order ID.
     */
    private int orderId;

    /**
     * Order constructor.
     * @param operation order.
     * @param price order.
     * @param volume order.
     * @param orderId order.
     */
    public Order(String operation, double price, int volume, int orderId) {
        this.operation = operation;
        this.price = price;
        this.volume = volume;
        this.orderId = orderId;
    }

    /**
     * Get operation.
     * @return operation.
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Get price.
     * @return price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get volume.
     * @return volume.
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Get order ID;
     * @return id.
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Set volume.
     * @param volume new order.
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
