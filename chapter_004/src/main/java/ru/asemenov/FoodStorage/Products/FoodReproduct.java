package ru.asemenov.FoodStorage.Products;

import java.util.Date;
/**
 * Class FoodReproduct решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class FoodReproduct extends Food {
    /**
     * Can reproduct.
     */
    private boolean canReproduct;
    /**
     * Food constructor.
     * @param name        name.
     * @param expaireDate expaireDate.
     * @param createDate  createDate.
     * @param price       price.
     * @param discount    discount.
     * @param canRreproduct true.
     */
    public FoodReproduct(String name, Date expaireDate, Date createDate, double price, double discount, boolean canRreproduct) {
        super(name, expaireDate, createDate, price, discount);
        this.canReproduct = canRreproduct;
    }
    /**
     * Boolean can reproduct.
     * @return true.
     */
    public boolean isCanReproduct() {
        return canReproduct;
    }
}
