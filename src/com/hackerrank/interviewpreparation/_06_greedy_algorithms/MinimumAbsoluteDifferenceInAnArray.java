package com.hackerrank.interviewpreparation._06_greedy_algorithms;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceInAnArray {

    public static void main(String[] args) {
        if (true) {
            MinimumAbsoluteDifferenceInAnArray c = new MinimumAbsoluteDifferenceInAnArray();
            int[] arr = {3, -7, 0};

            System.out.println("Result " + c.minimumAbsoluteDifference(arr)); //expected 3
        }

        if (true) {
            MinimumAbsoluteDifferenceInAnArray c = new MinimumAbsoluteDifferenceInAnArray();
            int[] arr = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};

            System.out.println("Result " + c.minimumAbsoluteDifference(arr)); //expected 1
        }

        if (true) {
            MinimumAbsoluteDifferenceInAnArray c = new MinimumAbsoluteDifferenceInAnArray();
            int[] arr = {1, -3, 71, 68, 17};

            System.out.println("Result " + c.minimumAbsoluteDifference(arr)); //expected 3
        }
    }

    private int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(Math.abs(arr[i] - arr[i + 1]), min);
            if (min == 0) return 0;
        }

        return min;
    }

}
