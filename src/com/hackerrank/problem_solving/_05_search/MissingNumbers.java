package com.hackerrank.problem_solving._05_search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MissingNumbers {

    public static void main(String[] args) {
        MissingNumbers o = new MissingNumbers();

        //Test Case 0
        if (true) {
            o.runTestCase("in/problem_solving/_05_search/MissingNumbers_TestCase0"); //expected 204 205 206
        }


        //Test Case 1
        if (true) {
            o.runTestCase("in/problem_solving/_05_search/MissingNumbers_TestCase1"); //expected 3670 3674 3677 3684 3685 3695 3714 3720
        }


        //Test Case 4
        if (true) {
            o.runTestCase("in/problem_solving/_05_search/MissingNumbers_TestCase4"); //expected 3 7 8 10 12
        }
    }

    private void runTestCase(String fileName) {
        try {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

                int n = Integer.valueOf(in.readLine());
                int[] arr = new int[n];
                String[] aLine = in.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.valueOf(aLine[i]);
                }

                n = Integer.valueOf(in.readLine());
                int[] brr = new int[n];
                String[] bLine = in.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    brr[i] = Integer.valueOf(bLine[i]);
                }

                int[] ans = missingNumbers(arr, brr);
                StringBuilder b = new StringBuilder();
                for (int i : ans) b.append(i).append(" ");

                System.out.println(b);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int[] missingNumbers(int[] arr, int[] brr) {
        int[] count = new int[10001];

        for (int i : brr) count[i]++;
        for (int i : arr) count[i]--;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) list.add(i);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = list.get(i);
        return ans;
    }


}
