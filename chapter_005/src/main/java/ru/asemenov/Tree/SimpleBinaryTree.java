package ru.asemenov.Tree;

import java.util.List;
/**
 * Interface SimpleBinaryTree решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public interface SimpleBinaryTree<E extends Comparable> {
    /**
     * Add children.
     * @param leaf element.
     * @param newLeaf element.
     */
    void addChild(BinaryLeaf<E> leaf, BinaryLeaf<E> newLeaf);

    /**
     * Get children.
     * @return children.
     */
    List<E> getChildren();
}
