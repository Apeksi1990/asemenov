package ru.asemenov.FoodStorage.Storage;

import ru.asemenov.FoodStorage.Products.Food;

import java.util.ArrayList;
/**
 * Class WarehouseNew решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class WarehouseNew extends Storage {
    /**
     * WarehouseNew constructor.
     * @param storage storage.
     */
    public WarehouseNew(InterfaceStorage storage) {
        super(storage);
    }
    /**
     * Food storage.
     */
    private ArrayList<Food> warehouseNew = new ArrayList<>();
    /**
     * Add product.
     * @param product product.
     */
    @Override
    public void addProduct(Food product) {
        if (super.getProducts().size() == 1) {
            this.warehouseNew.add(product);
        } else {
            super.addProduct(product);
        }
    }
    /**
     * Get products.
     * @return products.
     */
    @Override
    public ArrayList<Food> getProducts() {
        return this.warehouseNew;
    }
}
