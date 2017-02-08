package ru.asemenov.FoodStorage.Control;

import ru.asemenov.FoodStorage.Products.Food;
import ru.asemenov.FoodStorage.Storage.InterfaceStorage;

import java.util.ArrayList;
/**
 * Class ControlQuality решение задачи части 004 урока 5.
 * @author asemenov
 * @version 1
 */
public class ControlQualityResort extends ControlDecorator {
    /**
     * ControlDecorator constructor.
     * @param control control.
     */
    public ControlQualityResort(InterfaceControl control) {
        super(control);
    }

    /**
     * Storage resort food.
     */
    private ArrayList<Food> resortFood = new ArrayList<>();

    /**
     * Resort.
     */
    public void resort() {
        for (InterfaceStorage storage : super.getStorages()) {
            for (int i = 0; i < storage.getProducts().size(); i++) {
                resortFood.add(storage.getProducts().get(i));
                storage.getProducts().clear();
            }
        }
        for (Food food : resortFood) {
            super.controlAction(food);
        }
    }
}
