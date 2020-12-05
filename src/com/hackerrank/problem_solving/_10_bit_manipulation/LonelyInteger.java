package com.hackerrank.problem_solving._10_bit_manipulation;

import java.util.*;

public class LonelyInteger {

    public static void main(String[] args) {
        if (true) {
            LonelyInteger o = new LonelyInteger();
            int[] a = {1, 2, 3, 4, 3, 2, 1};

            System.out.println("Result = " + o.lonelyinteger(a));
        }

        if (true) {
            LonelyInteger o = new LonelyInteger();
            int[] a = {1, 1, 2};

            System.out.println("Result = " + o.lonelyinteger(a));
        }

        if (true) {
            LonelyInteger o = new LonelyInteger();
            int[] a = {0, 0, 1, 2, 1};

            System.out.println("Result = " + o.lonelyinteger(a));
        }
    }

    private int lonelyinteger(int[] a) {
        int ans = 0;
        for (int i : a) {
            ans = ans ^ i;
        }

        return ans;
    }

}
