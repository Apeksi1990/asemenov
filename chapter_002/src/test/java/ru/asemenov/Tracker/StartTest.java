package ru.asemenov.Tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StartTest решение задачи части 002 урока 3.
 * @author asemenov
 * @version 1
 */
public class StartTest {
    /**
     * Тест добавления заявки.
     */
    @Test
    public final void testAddItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "Alex", "info", "1", "Lesha", "newInfo", "0"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findAll();
        assertThat(result.length, is(2));
    }

    /**
     * Тест редактирование заявки.
     */
    @Test
    public final void testEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Alex", "info");
        tracker.add(item);
        Item[] idItem = tracker.findByName("Alex");
        String id = "";
        for (Item i : idItem) {
            id = i.getId();
        }
        Input input = new StubInput(new String[]{"2", id, "Lesha", "newInfo", "0"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is("Lesha"));
    }

    /**
     * Тест удаления заявки.
     */
    @Test
    public final void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Alex", "info");
        tracker.add(item);
        Item[] idItem = tracker.findByName("Alex");
        String id = "";
        for (Item i : idItem) {
            id = i.getId();
        }
        Input input = new StubInput(new String[]{"3", id, "0"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findAll();
        assertThat(result.length, is(0));
    }

    /**
     * Тест нахождения по имени.
     */
    @Test
    public final void testFindByName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "Alex", "info", "1", "Lesha", "newInfo", "6", "Alex", "0"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findByName("Alex");
        assertThat(result.length, is(1));
    }

    /**
     * Тест добавления комментария.
     */
    @Test
    public final void testAddComment() {
        Tracker tracker = new Tracker();
        Item item = new Item("Alex", "info");
        tracker.add(item);
        Item[] idItem = tracker.findByName("Alex");
        String id = "";
        for (Item i : idItem) {
            id = i.getId();
        }
        Input input = new StubInput(new String[]{"7", id, "newComment", "0"});
        new StartUI(input, tracker).init();
        String[] comment = tracker.findAll()[0].getComments();
        String result = comment[0];
        assertThat(result, is("newComment"));
    }
}
