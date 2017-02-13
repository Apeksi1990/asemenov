package ru.asemenov.Generic;
/**
 * Class SimpleArray решение задачи части 005.
 * @author asemenov
 * @param <E> generic.
 * @version 1
 */
public class SimpleArray<E> {
    /**
     * Objects.
     */
    private Object[] objects;
    /**
     * Index.
     */
    private int index = 0;

    /**
     * SimpleArray constructor.
     * @param size objects.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Add.
     * @param value value.
     */
    public void add(E value) {
        this.objects[index++] = value;
    }

    /**
     * Get value.
     * @param position value.
     * @return value.
     */
    public E get(int position) {
        return (E) this.objects[position];
    }

    /**
     * Update.
     * @param position value.
     * @param value new value.
     */
    public void update(int position, E value) {
        this.objects[position] = value;
    }

    /**
     * Delete.
     * @param position value.
     */
    public void delete(int position) {
        for (int i = position; i < objects.length - 1; i++) {
            this.objects[i] = this.objects[i + 1];
            this.objects[i + 1] = null;
        }
    }
}
