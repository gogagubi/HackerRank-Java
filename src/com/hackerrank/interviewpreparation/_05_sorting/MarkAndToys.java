package com.hackerrank.interviewpreparation._05_sorting;


import java.util.Arrays;

public class MarkAndToys {

    public static void main(String[] args) {
        if (true) {
            MarkAndToys c = new MarkAndToys();
            int[] prices = {1, 12, 5, 111, 200, 1000, 10};
            int k = 50;

            System.out.println("Result " + c.maximumToys(prices, k));
        }
    }

    private int maximumToys(int[] prices, int k) {
        int maxToys = 0;
        Arrays.sort(prices);
        for (int price : prices) {
            if (k < price) break;
            k -= price;
            maxToys++;
        }

        return maxToys;
    }

}
