package com.hackerrank.interviewpreparation._07_linkedlist;


import com.hackerrank.model.linkedList.DoublyLinkedListNode;

public class InsertingNodeIntoSortedDoublyLinkedList {

    public static void main(String[] args) {
        if (true) {
            InsertingNodeIntoSortedDoublyLinkedList o = new InsertingNodeIntoSortedDoublyLinkedList();
            int data = 5;
            DoublyLinkedListNode head = new DoublyLinkedListNode(1, 3, 4, 10);

            System.out.println("Result: " + o.sortedInsert(head, data).show());
        }

        if (true) {
            InsertingNodeIntoSortedDoublyLinkedList o = new InsertingNodeIntoSortedDoublyLinkedList();
            int data = 5;
            DoublyLinkedListNode head = new DoublyLinkedListNode(1);

            System.out.println("Result: " + o.sortedInsert(head, data).show());
        }

        if (true) {
            InsertingNodeIntoSortedDoublyLinkedList o = new InsertingNodeIntoSortedDoublyLinkedList();
            int data = 5;
            DoublyLinkedListNode head = new DoublyLinkedListNode(6);

            System.out.println("Result: " + o.sortedInsert(head, data).show());
        }

        if (true) {
            InsertingNodeIntoSortedDoublyLinkedList o = new InsertingNodeIntoSortedDoublyLinkedList();
            int data = 2;

            System.out.println("Result: " + o.sortedInsert(null, data).show());
        }

        if (true) {
            InsertingNodeIntoSortedDoublyLinkedList o = new InsertingNodeIntoSortedDoublyLinkedList();
            int data = 3;
            DoublyLinkedListNode head = new DoublyLinkedListNode(1, 3, 4, 10);

            System.out.println("Result: " + o.sortedInsert(head, data).show());
        }

        if (true) {
            InsertingNodeIntoSortedDoublyLinkedList o = new InsertingNodeIntoSortedDoublyLinkedList();
            int data = 3;
            DoublyLinkedListNode head = new DoublyLinkedListNode(1, 3, 3, 4, 10);

            System.out.println("Result: " + o.sortedInsert(head, data).show());
        }
    }

    private DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode root = new DoublyLinkedListNode(0);
        root.next = head;
        if(head != null) head.prev = root;
        DoublyLinkedListNode tmp = root;

        while (tmp != null) {
            if (data >= tmp.data && (tmp.next == null || data < tmp.next.data)) {
                DoublyLinkedListNode node = new DoublyLinkedListNode(data);
                node.next = tmp.next;
                node.prev = tmp;

                tmp.next = node;
                tmp.next.prev = node;
                break;
            }

            tmp = tmp.next;
        }

        return root.next;
    }

}
