package ru.asemenov.FoodStorage;

import org.junit.Before;
import org.junit.Test;
import ru.asemenov.FoodStorage.Control.ControlQuality;
import ru.asemenov.FoodStorage.Control.ControlQualityResort;
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
public class ControlQualityResortTest {
    /**
     * Simple date format.
     */
    private SimpleDateFormat sdf;
    /**
     * ControlQuality.
     */
    private ControlQuality control;
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
     * @throws  ParseException exception.
     */
    @Before
    public void beforeTest() throws ParseException {
        sdf = new SimpleDateFormat("dd.MM.yyyy");
        control = new ControlQuality();
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        control.addStorage(warehouse);
        control.addStorage(shop);
        control.addStorage(trash);

        Date dateCreate = sdf.parse("01.01.2017");

        Date dateExpiry = sdf.parse("11.06.2017");
        Chicken chicken = new Chicken("chicken", dateExpiry, dateCreate, 20, 0);
        control.controlAction(chicken);

        Date dateExpiryFish = sdf.parse("11.04.2017");
        Fish fish = new Fish("fish", dateExpiryFish, dateCreate, 20, 0);
        control.controlAction(fish);

        Date dateExpiryMeat = sdf.parse("25.01.2017");
        Meat meat = new Meat("meat", dateExpiryMeat, dateCreate, 20, 0);
        control.controlAction(meat);
    }

    /**
     * Resort test.
     */
    @Test
    public void resortTest() {
        ControlQualityResort resort = new ControlQualityResort(control);
        resort.resort();
        int resultWarehouse = warehouse.getProducts().size();
        int resultShop = shop.getProducts().size();
        int resultTrash = trash.getProducts().size();
        assertThat(resultWarehouse, is(1));
        assertThat(resultShop, is(1));
        assertThat(resultTrash, is(1));
    }
}
