package ru.asemenov.List;
/**
 * Class QueueList решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T> generic.
 */
public class QueueList<T> implements SimpleQueue<T> {
    /**
     * List storage.
     */
    private LinkedList<T> list = new LinkedList<T>();
    /**
     * Push element.
     * @param t element.
     */
    @Override
    public void push(T t) {
        list.add(t);
    }

    /**
     * Get element.
     * @return element.
     */
    @Override
    public T poll() {
        T result;
        result = list.get(0);
        list.delete(0);
        return result;
    }
}
