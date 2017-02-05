package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;
/**
 * Class Reproduct решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class Reproduct implements InterfaceStorage {
    /**
     * Percent trash.
     */
    private double percentTrash = 100;
    /**
     * Reproduct food.
     */
    private ArrayList<Food> reproduct = new ArrayList<>();
    /**
     * Add product.
     * @param product product.
     */
    @Override
    public void addProduct(Food product) {
        this.reproduct.add(product);
    }
    /**
     * Get products.
     * @return products.
     */
    @Override
    public ArrayList<Food> getProducts() {
        return this.reproduct;
    }
    /**
     * Condition.
     * @param product product.
     * @return boolean.
     */
    @Override
    public boolean condition(Food product) {
        return product.getPercentExpiryDate() >= percentTrash;
    }
}