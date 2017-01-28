package ru.asemenov.FoodStorage.Products;

import java.util.Date;
/**
 * Class Food решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class Food {
    /**
     * Name.
     */
    private String name;
    /**
     * Expiry Date.
     */
    private Date expaireDate;
    /**
     * Create date.
     */
    private Date createDate;
    /**
     * Price.
     */
    private double price;
    /**
     * Discount.
     */
    private double discount;
    /**
     * Food constructor.
     * @param name name.
     * @param expaireDate expaireDate.
     * @param createDate createDate.
     * @param price price.
     * @param discount discount.
     */
    public Food(String name, Date expaireDate, Date createDate, double price, double discount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }
    /**
     * Set discount.
     * @param discount discount.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    /**
     * Get discount.
     * @return discount.
     */
    public double getDiscount() {
        return discount;
    }
    /**
     * Get percent expiry date.
     * @return percent.
     */
    public double getPercentExpiryDate() {
        return (double) (System.currentTimeMillis() - this.createDate.getTime())
                / (this.expaireDate.getTime() - this.createDate.getTime()) * 100;
    }
}