package ru.asemenov.Tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class TreeTest решение задачи части 005.
 * @author asemenov
 * @version 1
 */
public class TreeTest {
    /**
     * Root tree.
     */
    private Leaf<String> root;
    /**
     * Tree.
     */
    private Tree<String> tree;

    /**
     * Add leaf.
     */
    @Before
    public void createTree() {
        root = new Leaf<>("Корень");
        Leaf<String> leaf1 = new Leaf<>("1");
        Leaf<String> leaf2 = new Leaf<>("2");
        Leaf<String> leaf11 = new Leaf<>("11");
        Leaf<String> leaf12 = new Leaf<>("12");
        Leaf<String> leaf21 = new Leaf<>("21");
        Leaf<String> leaf22 = new Leaf<>("22");
        tree = new Tree<>();
        tree.addChild(root, leaf1);
        tree.addChild(root, leaf2);
        tree.addChild(leaf1, leaf11);
        tree.addChild(leaf1, leaf12);
        tree.addChild(leaf2, leaf21);
        tree.addChild(leaf2, leaf22);
    }

    /**
     * Get children test.
     */
    @Test
    public void whenCreateTreeThenReturnCorrectTree() {
        assertThat(tree.getChildren().size(), is(6));
    }

    /**
     * Find leaf test.
     */
    @Test
    public void whenSearchValueThenFindCorrectLeaf() {
        assertThat(tree.findLeaf("21").getValue(), is("21"));
    }

    /**
     * Balance test.
     */
    @Test
    public void whenGiveTreeThenReturnBalance() {
        Leaf<String> leaf23 = new Leaf<>("23");
        tree.addChild(root, leaf23);
        assertThat(tree.isBalance(), is(false));
    }
}