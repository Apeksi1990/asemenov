package ru.asemenov.Tree;

import java.util.ArrayList;
import java.util.List;
/**
 * Class Tree решение задачи части 005.
 * @author asemenov
 * @version 1
 * @param <E> generic.
 */
public class Tree<E> implements SimpleTree<E> {
    /**
     * Main root tree.
     */
    private Leaf<E> main;
    /**
     * Add children.
     * @param leaf parent element.
     * @param newLeaf new element.
     */
    @Override
    public void addChild(Leaf<E> leaf, Leaf<E> newLeaf) {
        if (this.main == null) {
            this.main = leaf;
        }
        leaf.addChildren(newLeaf);
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
    private void readChildren(List<E> list, Leaf<E> leaf) {
        for (Leaf<E> e : leaf.getChildren()) {
            if (e.getChildren().size() != 0) {
                readChildren(list, e);
            }
            list.add(e.getValue());
        }
    }

    /**
     * Find leaf for value.
     * @param value E.
     * @return Leaf.
     */
    public Leaf<E> findLeaf(E value) {
        return find(value, this.main);
    }

    /**
     * Find.
     * @param value E.
     * @param leaf E.
     * @return leaf.
     */
    private Leaf<E> find(E value, Leaf<E> leaf) {
        Leaf<E> result = null;
        if (value.equals(leaf.getValue())) {
            result = leaf;
        } else if (leaf.getChildren().size() != 0) {
            for (Leaf<E> e : leaf.getChildren()) {
                if (result == null) {
                    result = find(value, e);
                }
            }
        }
        return result;
    }

    /**
     * Is balance.
     * @return boolean.
     */
    public boolean isBalance() {
        return treeBalance(this.main);
    }
    /**
     * Balance.
     * @param leaf E.
     * @return boolean.
     */
    private boolean treeBalance(Leaf<E> leaf) {
        boolean result = true;
        if (leaf.getChildren().size() != 2 && leaf.getChildren().size() != 0) {
            result = false;
        } else {
            for (Leaf<E> e : leaf.getChildren()) {
                result = treeBalance(e);
            }
        }
        return result;
    }
}
