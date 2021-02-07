package com.hackerrank.problem_solving._04_sorting;


public class InsertionSortPart1 {

    public static void main(String[] args) {
        if (true) {
            InsertionSortPart1 c = new InsertionSortPart1();
            int[] a = {2, 4, 6, 8, 3};

            c.insertionSort1(a.length, a);
            System.out.println();
        }

        if (true) {
            InsertionSortPart1 c = new InsertionSortPart1();
            int[] a = {1, 3, 5, 9, 13, 22, 27, 35, 46, 51, 55, 83, 87, 23};

            c.insertionSort1(a.length, a);
            System.out.println();
        }

        if (true) {
            InsertionSortPart1 c = new InsertionSortPart1();
            int[] a = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};

            c.insertionSort1(a.length, a);
            System.out.println();
        }
    }

    private void insertionSort1(int n, int[] arr) {
        int reserved = arr[arr.length - 1];
        for (int i = n - 1; i >= 0; i--) {

            if (i == 0 || reserved > arr[i - 1]) {
                arr[i] = reserved;
                print(arr);
                break;
            } else {
                arr[i] = arr[i - 1];
                print(arr);
            }
        }
    }

    private void print(int[] arr) {
        StringBuilder res = new StringBuilder();
        for (int e : arr) res.append(e).append(" ");
        System.out.println(res);
    }

}
