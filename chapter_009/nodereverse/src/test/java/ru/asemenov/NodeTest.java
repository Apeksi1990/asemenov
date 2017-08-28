package ru.asemenov;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class NodeTest {
    @Test
    public void reverse() {
        Node node = null;
        node = new Node(node, 3);
        node = new Node(node, 2);
        node = new Node(node, 1);
        node = node.convert(node);
        List<Integer> result = new ArrayList<>();
        node.getResult(result);
        int[] array = {3,2,1};
        Assert.assertThat(Arrays.toString(result.toArray()), is(Arrays.toString(array)));
    }
}