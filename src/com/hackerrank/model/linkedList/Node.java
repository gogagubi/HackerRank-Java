package com.hackerrank.model.linkedList;

public class Node {
    public Node next;
    public int val;

    public Node(int x) {
        this.val = x;
        this.next = null;
    }

    public Node(int... values) {
        if (values.length == 0) {
            return;
        }

        this.val = values[0];
        Node tmp = this;

        for (int i = 1; i < values.length; i++) {
            tmp.next = new Node(values[i]);
            tmp = tmp.next;
        }
    }

    public void addLast(Node node) {
        Node tmp = this;
        while (tmp != null && tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = node;
    }

    public String show() {
        StringBuilder builder = new StringBuilder();
        Node node = this;
        while (node != null) {
            builder.append(node.val);
            if (node.next != null) {
                builder.append("->");
            }
            node = node.next;
        }

        return builder.toString();
    }

    public int size() {
        Node node = this;
        int s = 0;
        while (node != null) {
            s++;
            node = node.next;
        }

        return s;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}