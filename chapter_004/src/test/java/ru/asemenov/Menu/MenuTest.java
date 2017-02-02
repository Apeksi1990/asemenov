package ru.asemenov.Menu;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class MenuTest решение задачи части 004 урока 4.
 * @author asemenov
 * @version 1
 */
public class MenuTest {
    /**
     * Menu.
     */
    private Menu menu;
    /**
     * Before test.
     */
    @Before
    public void beforeMenuTest() {
        Input input = new StubInput(new String[]{"1", "y"});
        menu = new Menu(input);
        menu.fillItem();
    }
    /**
     * Item size test.
     */
    @Test
    public void itemSize() {
        int result = 6;
        assertThat(menu.getItem().size(), is(result));
    }
    /**
     * Check key test.
     */
    @Test
    public void testCheckKey() {
        String name = "Task 1";
        String result = menu.checkKey("1").getName();
        assertThat(result, is(name));
    }

}
