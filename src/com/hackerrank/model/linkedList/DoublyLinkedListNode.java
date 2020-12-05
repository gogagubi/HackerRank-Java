package com.hackerrank.model.linkedList;

public class DoublyLinkedListNode {
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;
    public int data;

    public DoublyLinkedListNode(int data) {
        this.data = data;
    }

    public DoublyLinkedListNode(int... values) {
        if (values.length == 0) {
            return;
        }

        this.data = values[0];
        DoublyLinkedListNode tmp = this;

        for (int i = 1; i < values.length; i++) {
            tmp.next = new DoublyLinkedListNode(values[i]);
            tmp.next.prev = tmp;
            tmp = tmp.next;
        }
    }

    public void addLast(DoublyLinkedListNode node) {
        DoublyLinkedListNode tmp = this;
        while (tmp != null && tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = node;
        tmp.next.prev = tmp;
    }

    public String show() {
        StringBuilder builder = new StringBuilder();
        DoublyLinkedListNode node = this;
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
        DoublyLinkedListNode node = this;
        int s = 0;
        while (node != null) {
            s++;
            node = node.next;
        }

        return s;
    }

    @Override
    public String toString() {
        return "DoublyLinkedListNode{" +
                "prev=" + (prev != null ? prev.data : "null") + ", " +
                "next=" + next + ", " +
                "data=" + data +
                '}';
    }
}