package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;

/**
 * Class Trash решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class Trash implements InterfaceStorage {
    /**
     * Percent trash.
     */
    private double percentTrash = 100;
    /**
     * Food storage.
     */
    private ArrayList<Food> trashFood = new ArrayList<>();
    /**
     * Add product.
     * @param product product.
     */
    @Override
    public void addProduct(Food product) {
        this.trashFood.add(product);
    }
    /**
     * Get product.
     * @return product.
     */
    @Override
    public ArrayList<Food> getProducts() {
        return trashFood;
    }
    /**
     * Condition to add the product.
     * @param product product.
     * @return boolean.
     */
    @Override
    public boolean condition(Food product) {
        return product.getPercentExpiryDate() >= percentTrash;
    }
}
