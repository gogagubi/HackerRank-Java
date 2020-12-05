package com.hackerrank.interviewpreparation._08_search;

import java.util.Set;
import java.util.TreeSet;

public class TripleSum {

    public static void main(String[] args) {
        if (true) {
            TripleSum o = new TripleSum();
            int[] a = {1, 3, 5};
            int[] b = {2, 3};
            int[] c = {1, 2, 3};

            System.out.println("Result: " + o.triplets(a, b, c)); //Expected 8
        }

        if (true) {
            TripleSum o = new TripleSum();
            int[] a = {1, 4, 5};
            int[] b = {2, 3, 3};
            int[] c = {1, 2, 3};

            System.out.println("Result: " + o.triplets(a, b, c)); //Expected 5
        }

        if (true) {
            TripleSum o = new TripleSum();
            int[] a = {1, 3, 5, 7};
            int[] b = {5, 7, 9};
            int[] c = {7, 9, 11, 13};

            System.out.println("Result: " + o.triplets(a, b, c)); //Expected 12
        }
    }

    private long triplets(int[] a, int[] b, int[] c) {
        a = uniqueSortedArray(a);
        b = uniqueSortedArray(b);
        c = uniqueSortedArray(c);

        long total = 0;
        for (int i = 0; i < b.length; i++) {
            int p = 0, r = 0;

            while (p < a.length && b[i] >= a[p]) p++;
            while (r < c.length && b[i] >= c[r]) r++;

            total += p * (long) r;
        }

        return total;
    }

    private int[] uniqueSortedArray(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr) set.add(i);
        int[] res = new int[set.size()];

        int ind = 0;
        for (int i : set) res[ind++] = i;

        return res;
    }

}
