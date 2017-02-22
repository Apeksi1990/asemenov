package ru.asemenov.Tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class BinaryTreeTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class BinaryTreeTest {
    /**
     * Root tree.
     */
    private BinaryLeaf<Integer> root;
    /**
     * Tree.
     */
    private BinaryTree<Integer> tree;

    /**
     * Before test.
     */
    @Before
    public void createBinaryTree() {
        root = new BinaryLeaf<>(0);
        BinaryLeaf<Integer> leaf1 = new BinaryLeaf<>(1);
        BinaryLeaf<Integer> leaf2 = new BinaryLeaf<>(2);
        BinaryLeaf<Integer> leaf11 = new BinaryLeaf<>(11);
        BinaryLeaf<Integer> leaf12 = new BinaryLeaf<>(12);
        BinaryLeaf<Integer> leaf21 = new BinaryLeaf<>(21);
        BinaryLeaf<Integer> leaf22 = new BinaryLeaf<>(22);
        tree = new BinaryTree<>();
        tree.addChild(root, leaf1);
        tree.addChild(root, leaf2);
        tree.addChild(root, leaf11);
        tree.addChild(root, leaf12);
        tree.addChild(root, leaf21);
        tree.addChild(root, leaf22);
    }

    /**
     * Get leafs test.
     */
    @Test
    public void whenAddLeafForBinaryTreeThenReturnAllLeafBinaryTree() {
        assertThat(tree.getChildren().size(), is(7));
    }

    /**
     * Find leaf test.
     */
    @Test
    public void whenSearchValueThenFindCorrectLeaf() {
        assertThat(tree.findLeaf(22, root).getValue(), is(22));
    }
}