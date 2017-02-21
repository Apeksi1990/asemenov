package ru.asemenov.Tree;

import java.util.List;
/**
 * Interface SimpleTree решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public interface SimpleTree<E> {
    /**
     * Add children.
     * @param leaf element.
     * @param e element.
     */
    void addChild(Leaf<E> leaf, Leaf<E> e);

    /**
     * Get children.
     * @return children.
     */
    List<E> getChildren();
}
