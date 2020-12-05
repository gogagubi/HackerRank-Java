package com.hackerrank.interviewpreparation._08_search;

import java.util.TreeSet;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        if (true) {
            MaximumSubarraySum o = new MaximumSubarraySum();
            long[] a = {1, 2, 3};
            long m = 2;

            System.out.println("Result: " + o.maximumSum(a, m)); //Expected 1
        }

        if (true) {
            MaximumSubarraySum o = new MaximumSubarraySum();
            long[] a = {1, 5, 9};
            long m = 5;

            System.out.println("Result: " + o.maximumSum(a, m)); //Expected 4
        }

        if (true) {
            MaximumSubarraySum o = new MaximumSubarraySum();
            long[] a = {3, 3, 9, 9, 5};
            long m = 7;

            System.out.println("Result: " + o.maximumSum(a, m)); //Expected 6
        }

        if (true) {
            MaximumSubarraySum o = new MaximumSubarraySum();
            long[] a = {3, 3, 9, 9, 5};
            long m = 19;

            System.out.println("Result: " + o.maximumSum(a, m)); //Expected 18
        }
    }

    private long maximumSum(long[] a, long m) {
        TreeSet<Long> set = new TreeSet<>();

        long currSum = 0;
        long max = 0;

        for (int i = 0; i < a.length; i++) {
            currSum = (currSum + a[i]) % m;
            max = Math.max(max, currSum);

            Long higher = set.higher(currSum);
            if (higher != null) {
                max = Math.max(max, currSum - higher + m);
            }

            set.add(currSum);
        }

        return max;
    }

}
