package ru.asemenov;

import java.util.List;

public class Node {
    Node next;
    int value;

    Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    Node convert(Node root) {
        Node head = null;
        Node current = root;
        while (current != null) {
            Node next = current.next;
            current.next = head;
            head = current;
            current = next;
        }
        return head;
    }

    void getResult(List<Integer> values) {
        values.add(value);
        if (next != null) {
            next.getResult(values);
        }
    }
}
