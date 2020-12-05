package com.hackerrank.interviewpreparation._07_linkedlist;


import com.hackerrank.model.linkedList.SinglyLinkedListNode;

public class InsertNodeAtSpecificPositionInLinkedList {

    public static void main(String[] args) {
        if (true) {
            InsertNodeAtSpecificPositionInLinkedList o = new InsertNodeAtSpecificPositionInLinkedList();
            int data = 4;
            int position = 2;
            SinglyLinkedListNode head = new SinglyLinkedListNode(1, 2, 3);

            System.out.println("Result: " + o.insertNodeAtPosition(head, data, position).show());
        }

        if (true) {
            InsertNodeAtSpecificPositionInLinkedList o = new InsertNodeAtSpecificPositionInLinkedList();
            int data = 3;
            int position = 1;
            SinglyLinkedListNode head = new SinglyLinkedListNode(1);

            System.out.println("Result: " + o.insertNodeAtPosition(head, data, position).show());
        }

        if (true) {
            InsertNodeAtSpecificPositionInLinkedList o = new InsertNodeAtSpecificPositionInLinkedList();
            int data = 4;
            int position = 0;

            System.out.println("Result: " + o.insertNodeAtPosition(null, data, position).show());
        }
    }

    private SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        int ind = 0;
        SinglyLinkedListNode root = new SinglyLinkedListNode(0);
        root.next = head;

        SinglyLinkedListNode tmp = root;

        while (tmp != null) {
            if (ind++ == position) {
                SinglyLinkedListNode node = new SinglyLinkedListNode(data);

                node.next = tmp.next;
                tmp.next = node;
                break;

            }

            tmp = tmp.next;
        }

        return root.next;
    }

}
