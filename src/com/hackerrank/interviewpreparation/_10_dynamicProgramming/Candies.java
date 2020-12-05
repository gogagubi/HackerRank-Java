package com.hackerrank.interviewpreparation._10_dynamicProgramming;

public class Candies {

    public static void main(String[] args) {
        if (true) {
            Candies o = new Candies();
            int[] arr = {4, 6, 4, 5, 6, 2};

            System.out.println("Result: " + o.candies(arr.length, arr));
        }

        if (true) {
            Candies o = new Candies();
            int[] arr = {2, 4, 2, 6, 1, 2, 8, 9, 2, 1};

            System.out.println("Result: " + o.candies(arr.length, arr));
        }
    }

    private long candies(int n, int[] arr) {
        int[] candies = new int[arr.length];
        candies[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }

        long sum = 0;
        for (int i : candies) {
            sum += i;
        }

        return sum;
    }
}
