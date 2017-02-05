package ru.asemenov.FoodStorage.Control;

import ru.asemenov.FoodStorage.Products.FoodCold;
import ru.asemenov.FoodStorage.Storage.InterfaceStorage;

import java.util.ArrayList;
/**
 * Class ControlQualityCold решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class ControlQualityCold extends ControlDecorator {
    /**
     * ControlDecorator constructor.
     * @param control control.
     */
    public ControlQualityCold(InterfaceControl control) {
        super(control);
    }

    /**
     * Cold storages.
     */
    private ArrayList<InterfaceStorage> coldStorage = new ArrayList<>();
    /**
     * Add storages.
     * @param storage storages.
     */
    public void addColdStorage(InterfaceStorage storage) {
        coldStorage.add(storage);
    }
    /**
     * Control vegetable.
     * @param product product.
     */
    public void controlVegetable(FoodCold product) {
        if (product.isVegetable()) {
            for (InterfaceStorage storage : this.coldStorage) {
                storage.addProduct(product);
                break;
            }
        } else {
            super.controlAction(product);
        }
    }
}
