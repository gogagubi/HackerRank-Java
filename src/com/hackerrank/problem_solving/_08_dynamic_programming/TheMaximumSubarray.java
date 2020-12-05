package com.hackerrank.problem_solving._08_dynamic_programming;

import java.util.Arrays;

public class TheMaximumSubarray {

    public static void main(String[] args) {
        if (true) {
            TheMaximumSubarray s = new TheMaximumSubarray();
            int[] arr = {1, 2, 3, 4};

            System.out.println("Result = " + Arrays.toString(s.maxSubarray(arr)));
        }

        if (true) {
            TheMaximumSubarray s = new TheMaximumSubarray();
            int[] arr = {2, -1, 2, 3, 4, -5};

            System.out.println("Result = " + Arrays.toString(s.maxSubarray(arr)));
        }

        if (true) {
            TheMaximumSubarray s = new TheMaximumSubarray();
            int[] arr = {-2, -3, -1, -4, -6};

            System.out.println("Result = " + Arrays.toString(s.maxSubarray(arr)));
        }
    }

    private int[] maxSubarray(int[] arr) {
        int subarraySum = arr[0];
        int subsetSum = arr[0];

        int subarrayDp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            subarrayDp = Math.max(subarrayDp + arr[i], arr[i]);
            subarraySum = Math.max(subarraySum, subarrayDp);

            int before = subsetSum + arr[i];
            subsetSum = Math.max(subsetSum, arr[i]);
            subsetSum = Math.max(subsetSum, before);
        }

        return new int[]{subarraySum, subsetSum};
    }

}
