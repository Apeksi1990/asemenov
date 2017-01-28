package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;
/**
 * Class Storage решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public abstract class Storage {
    /**
     * Add product.
     * @param product product.
     */
    public abstract void addProduct(Food product);
    /**
     * Get product.
     * @return product.
     */
    public abstract ArrayList<Food> getProducts();
    /**
     * Condition to add the product.
     * @param product product.
     * @return boolean.
     */
    public abstract boolean condition(Food product);
    /**
     * Discount.
     */
    double discount = 10;
    /**
     * 25%.
     */
    double percentWarehouse = 25;
    /**
     * 75%.
     */
    double percentShop = 75;
    /**
     * 100%.
     */
    double percentTrash = 100;
}
