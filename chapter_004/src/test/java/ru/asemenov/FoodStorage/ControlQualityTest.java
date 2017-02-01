package ru.asemenov.FoodStorage;

import org.junit.Before;
import org.junit.Test;
import ru.asemenov.FoodStorage.Products.Chicken;
import ru.asemenov.FoodStorage.Products.Fish;
import ru.asemenov.FoodStorage.Products.Meat;
import ru.asemenov.FoodStorage.Storage.InterfaceStorage;
import ru.asemenov.FoodStorage.Storage.Shop;
import ru.asemenov.FoodStorage.Storage.Trash;
import ru.asemenov.FoodStorage.Storage.Warehouse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ControlQualityTest решение задачи части 004 урока 3.
 * @author asemenov
 * @version 1
 */
public class ControlQualityTest {
    /**
     * Simple date format.
     */
    private SimpleDateFormat sdf;
    /**
     * ControlQuality.
     */
    private ControlQuality cq;
    /**
     * Warehouse.
     */
    private InterfaceStorage warehouse;
    /**
     * Shop.
     */
    private InterfaceStorage shop;
    /**
     * Trash.
     */
    private InterfaceStorage trash;

    /**
     * Before test.
     */
    @Before
    public void beforeTest() {
        sdf = new SimpleDateFormat("dd.MM.yyyy");
        cq = new ControlQuality();
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        cq.addStorage(warehouse);
        cq.addStorage(shop);
        cq.addStorage(trash);
    }
    /**
     * Add the product to Warehouse Test.
     * @throws ParseException exception.
     */
    @Test
    public void warehouseTest() throws ParseException {
        Date dateCreate = sdf.parse("01.01.2017");
        Date dateExpiry = sdf.parse("11.06.2017");
        Chicken chicken = new Chicken("chicken", dateExpiry, dateCreate, 20, 0);
        cq.controlAction(chicken);
        int result = warehouse.getProducts().size();
        assertThat(result, is(1));
    }
    /**
     * Add the product to Shop Test.
     * @throws ParseException exception.
     */
    @Test
    public void shopTest() throws ParseException {
        Date dateCreate = sdf.parse("01.01.2017");
        Date dateExpiry = sdf.parse("11.04.2017");
        Fish fish = new Fish("fish", dateExpiry, dateCreate, 20, 0);
        cq.controlAction(fish);
        int result = shop.getProducts().size();
        assertThat(result, is(1));
    }
    /**
     * Set discount Test.
     * @throws ParseException exception.
     */
    @Test
    public void discountTest() throws ParseException {
        Date dateCreate = sdf.parse("01.01.2017");
        Date dateExpiry = sdf.parse("05.02.2017");
        Fish fish = new Fish("fish", dateExpiry, dateCreate, 20, 0);
        cq.controlAction(fish);
        double result = fish.getDiscount();
        assertThat(result, is(10.0));
    }
    /**
     * Add the product to Trash Test.
     * @throws ParseException exception.
     */
    @Test
    public void trashTest() throws ParseException {
        Date dateCreate = sdf.parse("01.01.2017");
        Date dateExpiry = sdf.parse("25.01.2017");
        Meat meat = new Meat("meat", dateExpiry, dateCreate, 20, 0);
        cq.controlAction(meat);
        int result = trash.getProducts().size();
        assertThat(result, is(1));
    }
}
