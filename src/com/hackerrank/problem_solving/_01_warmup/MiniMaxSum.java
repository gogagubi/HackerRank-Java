package com.hackerrank.problem_solving._01_warmup;

public class MiniMaxSum {

    public static void main(String[] args) {
        if (true) {
            MiniMaxSum s = new MiniMaxSum();
            int[] arr = {1, 3, 5, 7, 9};

            s.miniMaxSum(arr);
        }

        if (true) {
            MiniMaxSum s = new MiniMaxSum();
            int[] arr = {256741038, 623958417, 467905213, 714532089, 938071625};

            s.miniMaxSum(arr);
        }


    }

    private void miniMaxSum(int[] arr) {
        int min = Integer.MAX_VALUE, max = 0;
        long sum = 0;

        for(int i = 0; i < arr.length; i ++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        long resultMin = sum - max;
        long resultMax = sum - min;
        System.out.println(resultMin + " " + resultMax);
    }

}
