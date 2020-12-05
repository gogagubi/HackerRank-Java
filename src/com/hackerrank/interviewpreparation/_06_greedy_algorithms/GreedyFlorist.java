package com.hackerrank.interviewpreparation._06_greedy_algorithms;

import java.util.Arrays;

public class GreedyFlorist {

    public static void main(String[] args) {
        if (true) {
            GreedyFlorist o = new GreedyFlorist();
            int k = 2;
            int[] arr = {1, 4, 7, 2};

            System.out.println("Result " + o.maxMin(k, arr)); //expected 29
        }
    }

    private int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - k + 1; i++) {
            answer = Math.min(answer, arr[i + k - 1] - arr[i]);
        }

        return answer;
    }

}
