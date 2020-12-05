package com.hackerrank.interviewpreparation._06_greedy_algorithms;

import java.util.Arrays;

public class MaxMin {

    public static void main(String[] args) {
        if (true) {
            MaxMin o = new MaxMin();
            int k = 3;
            int[] c = {1, 3, 5, 7, 9};

            System.out.println("Result " + o.getMinimumCost(k, c)); //expected 29
        }
    }

    private int getMinimumCost(int k, int[] c) {
        int n = c.length;

        int min = 0;
        int purchases = 0;
        int prevPurchases = 0;

        Arrays.sort(c);

        if (k >= n) {
            for (int i = 0; i < n; i++)
                min += c[i];
        } else {
            for (int i = n - 1; i >= 0; i--) {
                if (purchases == k) {
                    purchases = 0;
                    prevPurchases++;
                }
                min += (prevPurchases + 1) * c[i];
                purchases++;
            }
        }

        return min;
    }

}
