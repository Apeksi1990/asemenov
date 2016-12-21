package ru.asemenov.Tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class TrackerTest решение задачи части 002 урока 2.
 * @author asemenov
 * @version 1
 */
public class TrackerTest {
    /**
     * Тест добавления заявок.
     */
    @Test
    public void testAddItem() {
        Tracker tracker = new Tracker();
        Item expected = new Item("Alex", "info");
        Item result = tracker.add(expected);
        assertThat(result, is(expected));
    }

    /**
     * Тест обновления заявок.
     */
    @Test
    public void testEditItem() {
        Tracker tracker = new Tracker();
        Item result = new Item("Alex", "info");
        Item expected = new Item("Lesha", "newinfo");
        tracker.add(result);
        expected.setId(result.getId());
        tracker.update(expected);
        assertThat(result.getName(), is(expected.getName()));
        assertThat(result.getDescription(), is(expected.getDescription()));
    }

    /**
     * Тест удаления заявок.
     */
    @Test
    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Alex", "info"));
        tracker.delete(item.getId());
        Item result = tracker.findById(item.getId());
        Item expected = null;
        assertThat(result, is(expected));
    }
    /**
     * Тест поиска всех заявок.
     */
    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Alex", "info"));
        Item item1 = tracker.add(new Item("Alex", "info"));
        Item item2 = tracker.add(new Item("Alex", "info"));
        Item[] expected = new Item[]{item, item1, item2};
        assertThat(tracker.findAll(), is(expected));
    }
    /**
     * Тест поиска по имени.
     */
    @Test
    public void testFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Alex", "info"));
        Item item1 = tracker.add(new Item("Google", "info"));
        Item item2 = tracker.add(new Item("Yandex", "info"));
        Item[] expected = new Item[]{item1};
        assertThat(tracker.findByName("Google"), is(expected));
    }
    /**
     * Тест добвления комментариев.
     */
    @Test
    public void testAddComment() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Alex", "info"));
        tracker.addComment(item.getId(), "Privet");
        tracker.addComment(item.getId(), "Comment_1");
        tracker.addComment(item.getId(), "Comment_2");
        tracker.addComment(item.getId(), "Comment_3");
        tracker.addComment(item.getId(), "Comment_4");
        String[] expected = new String[]{"Privet", "Comment_1", "Comment_2", "Comment_3", "Comment_4"};
        assertThat(item.getComments(), is(expected));
    }
}