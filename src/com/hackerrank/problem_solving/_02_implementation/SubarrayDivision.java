package com.hackerrank.problem_solving._02_implementation;

import java.util.Arrays;
import java.util.List;

public class SubarrayDivision {

    public static void main(String[] args) {
        if (true) {
            SubarrayDivision o = new SubarrayDivision();
            List<Integer> s = Arrays.asList(2, 2, 1, 3, 2);
            int d = 4;
            int m = 2;

            System.out.println("Result = " + o.birthday(s, d, m));
        }

        if (true) {
            SubarrayDivision o = new SubarrayDivision();
            List<Integer> s = Arrays.asList(1, 2, 1, 3, 2);
            int d = 3;
            int m = 2;

            System.out.println("Result = " + o.birthday(s, d, m));
        }

        if (true) {
            SubarrayDivision o = new SubarrayDivision();
            List<Integer> s = Arrays.asList(1, 1, 1, 1, 1, 1);
            int d = 3;
            int m = 2;

            System.out.println("Result = " + o.birthday(s, d, m));
        }

        if (true) {
            SubarrayDivision o = new SubarrayDivision();
            List<Integer> s = Arrays.asList(4);
            int d = 4;
            int m = 1;

            System.out.println("Result = " + o.birthday(s, d, m));
        }
    }

    public int birthday(List<Integer> s, int d, int m) {
        int ans = 0;

        int i = 0;
        while (i < s.size()) {
            int sum = 0;

            for (int j = i; j < i + m && j < s.size(); j++) {
                sum += s.get(j);
                if (j == i + m - 1 && sum == d) {
                    ans++;
                }
            }

            i ++;
        }


        return ans;
    }

}
