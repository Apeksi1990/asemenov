package ru.asemenov.Tree;

import java.util.ArrayList;
import java.util.List;
/**
 * Class Leaf решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public class Leaf<E> {
    /**
     * Children.
     */
    private List<Leaf<E>> children;
    /**
     * Value.
     */
    private E value;

    /**
     * Leaf constructor.
     * @param value element.
     */
    public Leaf(E value) {
        this.value = value;
        children = new ArrayList<>();
    }

    /**
     * Add children.
     * @param leaf child.
     */
    public void addChildren(Leaf<E> leaf) {
        this.children.add(leaf);
    }

    /**
     * Get value.
     * @return E.
     */
    public E getValue() {
        return this.value;
    }

    /**
     * Get children.
     * @return children.
     */
    public List<Leaf<E>> getChildren() {
        return this.children;
    }

    /**
     * Override hashCode.
     * @return hash.
     */
    @Override
    public int hashCode() {
        return 31 * (this.children.hashCode()) + this.value.hashCode();
    }

    /**
     * Override equals.
     * @param obj object.
     * @return equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Leaf<E> leaf = (Leaf<E>) obj;
        if (!this.children.equals(leaf.children)) {
            return false;
        }
        return value.equals(value);
    }
}
