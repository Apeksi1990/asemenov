package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;
/**
 * Interface InterfaceStorage решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public interface InterfaceStorage {
    /**
     * Add product.
     * @param product product.
     */
    void addProduct(Food product);
    /**
     * Get products.
     * @return products.
     */
    ArrayList<Food> getProducts();
    /**
     * Condition.
     * @param product product.
     * @return boolean.
     */
    boolean condition(Food product);
}
