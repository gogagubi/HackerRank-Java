package com.hackerrank.interviewpreparation._05_sorting;


public class SortingBubbleSort {

    public static void main(String[] args) {
        if (true) {
            SortingBubbleSort c = new SortingBubbleSort();
            int[] a = {1, 2, 3};

            c.countSwaps(a);
            System.out.println();
        }

        if (true) {
            SortingBubbleSort c = new SortingBubbleSort();
            int[] a = {3, 2, 1};

            c.countSwaps(a);
            System.out.println();
        }
    }

    private void countSwaps(int[] a) {
        int swaps = 0, count;
        for (int i = 0; i < a.length; i++) {
            count = 0;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    count++;
                }
            }
            if (count == 0) break;
            swaps += count;
        }

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

    private void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
}
