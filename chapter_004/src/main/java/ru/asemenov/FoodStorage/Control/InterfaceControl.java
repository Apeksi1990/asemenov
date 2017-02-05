package ru.asemenov.FoodStorage.Control;

import ru.asemenov.FoodStorage.Products.Food;
import ru.asemenov.FoodStorage.Storage.InterfaceStorage;

import java.util.ArrayList;
/**
 * Interface InterfaceControl решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public interface InterfaceControl {
    /**
     * Get storages.
     * @return storages.
     */
    ArrayList<InterfaceStorage> getStorages();
    /**
     * Add storage.
     * @param storage storage.
     */
    void addStorage(InterfaceStorage storage);
    /**
     * Control action.
     * @param product product.
     */
    void controlAction(Food product);
}
