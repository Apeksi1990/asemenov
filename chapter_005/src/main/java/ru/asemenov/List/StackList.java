package ru.asemenov.List;

public class StackList<T> implements SimpleStack<T> {
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
        return null;
    }
}
