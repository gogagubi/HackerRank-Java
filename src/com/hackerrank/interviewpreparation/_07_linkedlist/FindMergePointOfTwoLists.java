package com.hackerrank.interviewpreparation._07_linkedlist;


import com.hackerrank.model.linkedList.SinglyLinkedListNode;

public class FindMergePointOfTwoLists {

    public static void main(String[] args) {
        if (true) {
            FindMergePointOfTwoLists o = new FindMergePointOfTwoLists();
            SinglyLinkedListNode head1 = new SinglyLinkedListNode(1, 3, 4, 10);
            SinglyLinkedListNode head2 = new SinglyLinkedListNode(2, 5);
            head2.next.next = head1.next;

            System.out.println("Result: " + o.findMergeNode(head1, head2));
        }

    }

    private int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        int head1Size = getSize(head1);
        int head2Size = getSize(head2);

        int difference = Math.abs(head1Size - head2Size);
        if (head1Size > head2Size) {
            while (difference > 0) {
                head1 = head1.next;
                difference--;
            }
        } else if (head1Size < head2Size) {
            while (difference > 0) {
                head2 = head2.next;
                difference--;
            }
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }

        return 0;
    }

    private int getSize(SinglyLinkedListNode node) {
        int size = 0;
        SinglyLinkedListNode ptr = node;
        while (ptr != null) {
            size++;
            ptr = ptr.next;
        }

        return size;
    }

}
