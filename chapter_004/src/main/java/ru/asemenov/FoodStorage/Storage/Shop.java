package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;
/**
 * Class Shop решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class Shop extends Storage {
    /**
     * Food storage.
     */
    private ArrayList<Food> shopFood = new ArrayList<>();
    /**
     * Add product.
     * @param product product.
     */
    @Override
    public void addProduct(Food product) {
        this.shopFood.add(product);
    }
    /**
     * Get product.
     * @return product.
     */
    @Override
    public ArrayList<Food> getProducts() {
        return shopFood;
    }
    /**
     * Condition to add the product.
     * @param product product.
     * @return boolean.
     */
    @Override
    public boolean condition(Food product) {
        boolean condition = false;
        if (product.getPercentExpiryDate() > percentWarehouse & product.getPercentExpiryDate() <= percentShop) {
            condition = true;
        } else if (product.getPercentExpiryDate() > percentShop & product.getPercentExpiryDate() < percentTrash) {
            condition = true;
            product.setDiscount(discount);
        }
        return condition;
    }
}
