package com.hackerrank.model.linkedList;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int x) {
        this.val = x;
        this.next = null;
    }

    public ListNode(int... values) {
        if (values.length == 0) {
            return;
        }

        this.val = values[0];
        ListNode tmp = this;

        for (int i = 1; i < values.length; i++) {
            tmp.next = new ListNode(values[i]);
            tmp = tmp.next;
        }
    }

    public void addLast(ListNode node) {
        ListNode tmp = this;
        while (tmp != null && tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = node;
    }

    public String show() {
        StringBuilder builder = new StringBuilder();
        ListNode node = this;
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
        ListNode node = this;
        int s = 0;
        while (node != null) {
            s++;
            node = node.next;
        }

        return s;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}