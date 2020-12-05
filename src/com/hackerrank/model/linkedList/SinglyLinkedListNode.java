package com.hackerrank.model.linkedList;

public class SinglyLinkedListNode {
    public SinglyLinkedListNode next;
    public int data;

    public SinglyLinkedListNode(int x) {
        this.data = x;
        this.next = null;
    }

    public SinglyLinkedListNode(int... values) {
        if (values.length == 0) {
            return;
        }

        this.data = values[0];
        SinglyLinkedListNode tmp = this;

        for (int i = 1; i < values.length; i++) {
            tmp.next = new SinglyLinkedListNode(values[i]);
            tmp = tmp.next;
        }
    }

    public void addLast(SinglyLinkedListNode node) {
        SinglyLinkedListNode tmp = this;
        while (tmp != null && tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = node;
    }

    public String show() {
        StringBuilder builder = new StringBuilder();
        SinglyLinkedListNode node = this;
        while (node != null) {
            builder.append(node.data);
            if (node.next != null) {
                builder.append("->");
            }
            node = node.next;
        }

        return builder.toString();
    }

    public int size() {
        SinglyLinkedListNode node = this;
        int s = 0;
        while (node != null) {
            s++;
            node = node.next;
        }

        return s;
    }

    @Override
    public String toString() {
        return "SinglyLinkedListNode{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}