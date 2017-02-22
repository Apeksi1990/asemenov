package ru.asemenov.Tree;
/**
 * Class BinaryLeaf решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public class BinaryLeaf<E extends Comparable> implements Comparable<E>  {
    /**
     * Left leaf.
     */
    private BinaryLeaf<E> left;
    /**
     * Right leaf.
     */
    private BinaryLeaf<E> right;
    /**
     * Value.
     */
    private E value;

    /**
     * BinaryLeaf constructor.
     * @param value E.
     */
    public BinaryLeaf(E value) {
        this.value = value;
    }

    /**
     * Get value.
     * @return value.
     */
    public E getValue() {
        return value;
    }

    /**
     * Get left leaf.
     * @return leaf.
     */
    public BinaryLeaf<E> getLeft() {
        return left;
    }

    /**
     * Set left leaf.
     * @param left leaf.
     */
    public void setLeft(BinaryLeaf<E> left) {
        this.left = left;
    }

    /**
     * Get right leaf.
     * @return leaf.
     */
    public BinaryLeaf<E> getRight() {
        return right;
    }

    /**
     * Set right leaf.
     * @param right leaf.
     */
    public void setRight(BinaryLeaf<E> right) {
        this.right = right;
    }

    /**
     * Override compareTo.
     * @param o E.
     * @return compareTo.
     */
    @Override
    public int compareTo(E o) {
        return this.value.compareTo(o);
    }

    /**
     * Override equals.
     * @param obj E.
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
        BinaryLeaf<E> leaf = (BinaryLeaf<E>) obj;

        return this.value.equals(leaf.value);
    }

    /**
     * Override hashCode.
     * @return hash.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
