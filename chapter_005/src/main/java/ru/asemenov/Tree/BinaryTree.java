package ru.asemenov.Tree;

import java.util.ArrayList;
import java.util.List;
/**
 * Class BinaryTree решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public class BinaryTree<E extends Comparable> implements SimpleBinaryTree<E> {
    /**
     * Main root tree.
     */
    private BinaryLeaf<E> main;
    /**
     * Add children.
     * @param leaf element.
     * @param newLeaf element.
     */
    @Override
    public void addChild(BinaryLeaf<E> leaf, BinaryLeaf<E> newLeaf) {
        if (this.main == null) {
            this.main = leaf;
        }
        if (leaf.compareTo(newLeaf.getValue()) == 1) {
            if (leaf.getLeft() == null) {
                leaf.setLeft(newLeaf);
            } else {
                addChild(leaf.getLeft(), newLeaf);
            }
        } else {
            if (leaf.getRight() == null) {
                leaf.setRight(newLeaf);
            } else {
                addChild(leaf.getRight(), newLeaf);
            }
        }
    }

    /**
     * Get children.
     * @return children.
     */
    @Override
    public List<E> getChildren() {
        List<E> result = new ArrayList<E>();
        readChildren(result, this.main);
        return result;
    }

    /**
     * Read children.
     * @param list result.
     * @param leaf child.
     */
    public void readChildren(List<E> list, BinaryLeaf<E> leaf) {
        if (leaf.getLeft() != null) {
            readChildren(list, leaf.getLeft());
        }
        if (leaf.getRight() != null) {
            readChildren(list, leaf.getRight());
        }
        list.add(leaf.getValue());
    }

    /**
     * Find leaf.
     * @param value E.
     * @param leaf E.
     * @return leaf.
     */
    public BinaryLeaf<E> findLeaf(E value, BinaryLeaf<E> leaf) {
        BinaryLeaf<E> result;
        if (value.equals(leaf.getValue())) {
            result = leaf;
        } else if (leaf.getLeft() != null || leaf.getRight() != null) {
            if (leaf.compareTo(value) == 1) {
                result = findLeaf(value, leaf.getLeft());
            } else {
                result = findLeaf(value, leaf.getRight());
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return result;
    }
}
