package com.hackerrank.interviewpreparation._05_sorting;

public class MergeSortCountingInversions {

    public static void main(String[] args) {
        if (false) {
            MergeSortCountingInversions c = new MergeSortCountingInversions();
            int[] arr = {1, 1, 1, 2, 2};

            System.out.println("Result " + c.countInversions(arr)); //Expected: 2
        }

        if (true) {
            MergeSortCountingInversions c = new MergeSortCountingInversions();
            int[] arr = {2, 1, 3, 1, 2};

            System.out.println("Result " + c.countInversions(arr)); //Expected: 2
        }

        if (true) {
            MergeSortCountingInversions c = new MergeSortCountingInversions();
            int[] arr = {7, 5, 3, 1};

            System.out.println("Result " + c.countInversions(arr)); //Expected: 2
        }
    }


    public long countInversions(int[] arr) {
        if (arr.length < 2) return 0;
        long count = 0;

        int middle = arr.length / 2;

        int[] L = new int[middle];
        int[] R = new int[arr.length - middle];

        for (int i = 0; i < arr.length; i++) {
            if (i < L.length) L[i] = arr[i];
            else R[i - middle] = arr[i];
        }

        count += countInversions(L);
        count += countInversions(R);
        count += merge(arr, L, R);
        return count;
    }

    private long merge(int[] arr, int[] L, int[] R) {
        int i = 0, j = 0, k = 0;
        long count = 0;

        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                count += L.length - i;
            }
        }

        while (i < L.length) arr[k++] = L[i++];
        while (j < R.length) arr[k++] = R[j++];
        return count;
    }

}
