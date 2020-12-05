package com.hackerrank.interviewpreparation._09_recurstion_and_backtracking;

import java.util.HashMap;
import java.util.Map;

public class RecursiveDigitSum {

    public static void main(String[] args) {
        if (true) {
            RecursiveDigitSum o = new RecursiveDigitSum();
            String n = "148";
            int k = 3;

            System.out.println("Result: " + o.superDigit(n, k));
        }

        if (true) {
            RecursiveDigitSum o = new RecursiveDigitSum();
            String n = "9875";
            int k = 4;

            System.out.println("Result: " + o.superDigit(n, k));
        }
    }

    private int superDigit(String n, int k) {
        if (n.length() == 1) return n.charAt(0) - '0';

        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }
        return superDigit(Long.toString(sum * k), 1);
    }


}
