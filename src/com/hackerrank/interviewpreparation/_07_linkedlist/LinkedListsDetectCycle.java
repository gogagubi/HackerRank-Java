package com.hackerrank.interviewpreparation._07_linkedlist;


import com.hackerrank.model.linkedList.Node;

public class LinkedListsDetectCycle {

    public static void main(String[] args) {
        if (true) {
            LinkedListsDetectCycle o = new LinkedListsDetectCycle();
            Node node = new Node(1, 2, 3);
            node.next.next.next = node.next.next;

            System.out.println("Result: " + o.has_cycle(node));
        }
    }

    private boolean has_cycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

}
