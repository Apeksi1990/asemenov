package ru.asemenov.FoodStorage;

import org.junit.Before;
import org.junit.Test;
import ru.asemenov.FoodStorage.Control.ControlQuality;
import ru.asemenov.FoodStorage.Control.ControlQualityCold;
import ru.asemenov.FoodStorage.Control.ControlQualityReproduct;
import ru.asemenov.FoodStorage.Products.Chicken;
import ru.asemenov.FoodStorage.Products.Food;
import ru.asemenov.FoodStorage.Products.FoodCold;
import ru.asemenov.FoodStorage.Products.FoodReproduct;
import ru.asemenov.FoodStorage.Storage.*;

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
public class ControlQualityNewTest {
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
    private InterfaceStorage warehouseNew;
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
        control = new ControlQuality();
        warehouseNew = new WarehouseNew(new Warehouse());
        shop = new Shop();
        trash = new Trash();
        control.addStorage(warehouseNew);
        control.addStorage(shop);
        control.addStorage(trash);
    }
    /**
     * Add the product to WarehouseNew Test.
     * @throws ParseException exception.
     */
    @Test
    public void warehouseNewTest() throws ParseException {
        Date dateCreate = sdf.parse("01.01.2017");
        Date dateExpiry = sdf.parse("11.06.2017");
        Food chicken = new Chicken("chicken", dateExpiry, dateCreate, 20, 0);
        Food chickenTwo = new Chicken("chickenTwo", dateExpiry, dateCreate, 20, 0);
        Food chickenThree = new Chicken("chickenThree", dateExpiry, dateCreate, 20, 0);
        control.controlAction(chicken);
        control.controlAction(chickenTwo);
        control.controlAction(chickenThree);
        int result = warehouseNew.getProducts().size();
        assertThat(result, is(2));
    }
    /**
     * Reproduct test.
     * @throws ParseException exception.
     */
    @Test
    public void foodReproductTest() throws ParseException {
        Date dateCreate = sdf.parse("01.01.2017");
        Date dateExpiry = sdf.parse("11.01.2017");
        Date dateExpiryShop = sdf.parse("11.04.2017");
        FoodReproduct chickenReproduct = new FoodReproduct("chicken", dateExpiry, dateCreate, 20, 0, true);
        FoodReproduct chickenShop = new FoodReproduct("chicken", dateExpiryShop, dateCreate, 20, 0, true);
        ControlQualityReproduct controlReproduct = new ControlQualityReproduct(control);
        InterfaceStorage reproduct = new Reproduct();
        controlReproduct.addStoragesReproduct(reproduct);
        controlReproduct.controlReproduct(chickenReproduct);
        controlReproduct.controlReproduct(chickenShop);
        int reproductSize = reproduct.getProducts().size();
        int shopSize = shop.getProducts().size();
        assertThat(reproductSize, is(1));
        assertThat(shopSize, is(1));
    }
    /**
     * Vegetables in cold storage.
     * @throws ParseException exception.
     */
    @Test
    public void coldVegetableTest() throws ParseException {
        Date dateCreate = sdf.parse("01.01.2017");
        Date dateExpiry = sdf.parse("11.03.2017");
        FoodCold vegetable = new FoodCold("tomat", dateExpiry, dateCreate, 20, 0, true, true);
        ControlQualityCold coldControl = new ControlQualityCold(new ControlQualityReproduct(control));
        ColdStorage coldStorage = new ColdStorage();
        coldControl.addColdStorage(coldStorage);
        coldControl.controlVegetable(vegetable);
        int coldStorageSize = coldStorage.getProducts().size();
        assertThat(coldStorageSize, is(1));
    }
}
