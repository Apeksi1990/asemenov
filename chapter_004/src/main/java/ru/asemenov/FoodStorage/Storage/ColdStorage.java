package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;
/**
 * Class ColdStorage решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class ColdStorage implements InterfaceStorage {
    /**
     * Percent trash.
     */
    private double percentTrash = 100;
    /**
     * Cold vegetable food.
     */
    private ArrayList<Food> coldFood = new ArrayList<>();
    /**
     * Add product.
     * @param product product.
     */
    @Override
    public void addProduct(Food product) {
        this.coldFood.add(product);
    }
    /**
     * Get products.
     * @return products.
     */
    @Override
    public ArrayList<Food> getProducts() {
        return coldFood;
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
