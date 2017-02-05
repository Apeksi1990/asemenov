package ru.asemenov.FoodStorage.Control;

import ru.asemenov.FoodStorage.Products.Food;
import ru.asemenov.FoodStorage.Storage.InterfaceStorage;

import java.util.ArrayList;
/**
 * Class ControlDecorator решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public abstract class ControlDecorator implements InterfaceControl {
    /**
     * InterfaceControl.
     */
    private InterfaceControl control;
    /**
     * ControlDecorator constructor.
     * @param control control.
     */
    ControlDecorator(InterfaceControl control) {
        this.control = control;
    }
    /**
     * Get storages.
     * @return storages.
     */
    @Override
    public ArrayList<InterfaceStorage> getStorages() {
        return control.getStorages();
    }
    /**
     * Add storage.
     * @param storage storage.
     */
    @Override
    public void addStorage(InterfaceStorage storage) {
        control.addStorage(storage);
    }
    /**
     * Control action.
     * @param product product.
     */
    @Override
    public void controlAction(Food product) {
        control.controlAction(product);
    }
}
