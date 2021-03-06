package ru.asemenov.List;
/**
 * Class StackList решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <T> generic.
 */
public class StackList<T> implements SimpleStack<T> {
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
    public T pop() {
        T result;
        result = list.get(list.size() - 1);
        list.delete(list.size() - 1);
        return result;
    }
}
