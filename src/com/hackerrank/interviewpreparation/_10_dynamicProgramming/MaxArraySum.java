package com.hackerrank.interviewpreparation._10_dynamicProgramming;

public class MaxArraySum {

    public static void main(String[] args) {
        if (true) {
            MaxArraySum o = new MaxArraySum();
            int[] arr = {-2, 1, 3, -4, 5};

            System.out.println("Result: " + o.maxSubsetSum(arr));
        }

        if (true) {
            MaxArraySum o = new MaxArraySum();
            int[] arr = {3, 7, 4, 6, 5};

            System.out.println("Result: " + o.maxSubsetSum(arr));
        }

        if (true) {
            MaxArraySum o = new MaxArraySum();
            int[] arr = {2, 1, 5, 8, 4};

            System.out.println("Result: " + o.maxSubsetSum(arr));
        }

        if (true) {
            MaxArraySum o = new MaxArraySum();
            int[] arr = {3, 5, -7, 8, 10};

            System.out.println("Result: " + o.maxSubsetSum(arr));
        }
    }

    private int maxSubsetSum(int[] arr) {
        int length = arr.length;
        if (length == 1) return arr[0];

        arr[0] = Math.max(0, arr[0]);
        arr[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < length; i++) {
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + arr[i]);
        }

        return arr[length - 1];
    }

    private int maxSubsetSumV1(int[] arr) {
        if (arr.length == 0) return 0;
        int curr = Math.max(arr[0], 0), prev = 0;

        for (int i = 1; i < arr.length; i++) {
            int tmp = curr;
            curr = Math.max(prev + arr[i], curr);
            prev = tmp;
        }

        return curr;
    }
}
