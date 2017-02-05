package ru.asemenov.FoodStorage.Control;

import ru.asemenov.FoodStorage.Products.FoodReproduct;
import ru.asemenov.FoodStorage.Storage.InterfaceStorage;

import java.util.ArrayList;
    /**
     * Class ControlQualityReproduct решение задачи части 004 урока 3.
     * @author asemenov
     * @version 1
     */
public class ControlQualityReproduct extends ControlDecorator {
    /**
     * ControlQualityReproduct constructor.
     * @param control control.
     */
    public ControlQualityReproduct(InterfaceControl control) {
        super(control);
    }
    /**
     * Storages reproduct.
     */
    private ArrayList<InterfaceStorage> storagesReproduct = new ArrayList<>();
    /**
     * Add storages.
     * @param storage storages.
     */
    public void addStoragesReproduct(InterfaceStorage storage) {
        storagesReproduct.add(storage);
    }
    /**
     * Control reproduct.
     * @param reproduct reproduct.
     */
    public void controlReproduct(FoodReproduct reproduct) {
        for (InterfaceStorage storage : this.storagesReproduct) {
            if (storage.condition(reproduct)) {
                storage.addProduct(reproduct);
                break;
            } else {
                super.controlAction(reproduct);
            }
        }
    }
}
