package ru.asemenov.FoodStorage.Products;

import java.util.Date;
/**
 * Class FoodCold решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class FoodCold extends FoodReproduct {
    /**
     * Boolean vegetetable.
     */
    private boolean vegetable;
    /**
     * Food constructor.
     * @param name          name.
     * @param expaireDate   expaireDate.
     * @param createDate    createDate.
     * @param price         price.
     * @param discount      discount.
     * @param canRreproduct true.
     * @param vegetable true.
     */
    public FoodCold(String name, Date expaireDate, Date createDate, double price, double discount, boolean canRreproduct, boolean vegetable) {
        super(name, expaireDate, createDate, price, discount, canRreproduct);
        this.vegetable = vegetable;
    }
    /**
     * Return vegetable.
     * @return boolean.
     */
    public boolean isVegetable() {
        return vegetable;
    }
}
