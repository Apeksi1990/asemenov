package ru.asemenov.FoodStorage;

import ru.asemenov.FoodStorage.Products.Food;
import ru.asemenov.FoodStorage.Storage.InterfaceStorage;

import java.util.ArrayList;

/**
 * Class ControlQuality решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class ControlQuality {
    /**
     * Storages.
     */
    private ArrayList<InterfaceStorage> storages = new ArrayList<>();
    /**
     * Add storage.
     * @param storage storage.
     */
    public void addStorage(InterfaceStorage storage) {
        this.storages.add(storage);
    }
    /**
     * Control action.
     * @param product product.
     */
    public void controlAction(Food product) {
        for (InterfaceStorage storage : this.storages) {
            if (storage.condition(product)) {
                storage.addProduct(product);
                break;
            }
        }
    }
}
