package ru.asemenov.FoodStorage;

import ru.asemenov.FoodStorage.Products.Food;
import ru.asemenov.FoodStorage.Storage.Storage;

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
    private ArrayList<Storage> storages = new ArrayList<>();
    /**
     * Add storage.
     * @param storage storage.
     */
    void addStorage(Storage storage) {
        this.storages.add(storage);
    }
    /**
     * Control action.
     * @param product product.
     */
    void controlAction(Food product) {
        for (Storage storage : this.storages) {
            if (storage.condition(product)) {
                storage.addProduct(product);
                break;
            }
        }
    }
}
