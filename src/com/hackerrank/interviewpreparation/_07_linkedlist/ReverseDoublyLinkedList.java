package com.hackerrank.interviewpreparation._07_linkedlist;


import com.hackerrank.model.linkedList.DoublyLinkedListNode;

public class ReverseDoublyLinkedList {

    public static void main(String[] args) {
        if (true) {
            ReverseDoublyLinkedList o = new ReverseDoublyLinkedList();
            DoublyLinkedListNode head = new DoublyLinkedListNode(1, 2, 3, 4);

            System.out.println("Result: " + o.reverse(head).show());
        }
    }

    private DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode result = null;

        while(head != null){
            DoublyLinkedListNode tmp = head;
            tmp.prev = tmp.next;
            head = head.next;

            tmp.next = result;
            result = tmp;


        }

        return result;
    }

}
