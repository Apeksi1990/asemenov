package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;

/**
 * Class Storage решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public abstract class Storage implements InterfaceStorage {
    /**
     * InterfaceStorage.
     */
    private InterfaceStorage storage;
    /**
     * Storage constructor.
     * @param storage storage.
     */
    Storage(InterfaceStorage storage) {
        this.storage = storage;
    }
    /**
     * Add product.
     * @param product product.
     */
    public void addProduct(Food product) {
        storage.addProduct(product);
    }
    /**
     * Get product.
     * @return product.
     */
    public ArrayList<Food> getProducts() {
        return storage.getProducts();
    }
    /**
     * Condition to add the product.
     * @param product product.
     * @return boolean.
     */
    public boolean condition(Food product) {
        return storage.condition(product);
    }
}
