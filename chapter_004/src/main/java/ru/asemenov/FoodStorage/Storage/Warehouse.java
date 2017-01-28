package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;
/**
 * Class Warehouse решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class Warehouse extends Storage {
    /**
     * Food storage.
     */
    private ArrayList<Food> warehouseFood = new ArrayList<>();
    /**
     * Add product.
     * @param product product.
     */
    @Override
    public void addProduct(Food product) {
        this.warehouseFood.add(product);
    }
    /**
     * Get product.
     * @return product.
     */
    @Override
    public ArrayList<Food> getProducts() {
        return this.warehouseFood;
    }
    /**
     * Condition to add the product.
     * @param product product.
     * @return boolean.
     */
    @Override
    public boolean condition(Food product) {
        return product.getPercentExpiryDate() <= percentWarehouse;
    }
}
