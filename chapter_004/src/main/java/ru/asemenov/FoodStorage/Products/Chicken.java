package ru.asemenov.FoodStorage.Products;

import java.util.Date;
/**
 * Class Chicken решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class Chicken extends Food {
    /**
     * Chicken constructor.
     * @param name name.
     * @param expaireDate expaireDate.
     * @param createDate createDate.
     * @param price price.
     * @param discount discount.
     */
    public Chicken(String name, Date expaireDate, Date createDate, double price, double discount) {
        super(name, expaireDate, createDate, price, discount);
    }
}
