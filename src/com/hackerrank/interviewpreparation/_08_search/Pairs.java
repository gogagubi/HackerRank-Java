package com.hackerrank.interviewpreparation._08_search;

import java.util.*;

public class Pairs {

    public static void main(String[] args) {
        if (true) {
            Pairs o = new Pairs();
            int[] arr = {1, 5, 3, 4, 2};
            int k = 1;

            System.out.println("Result: " + o.pairs(k, arr));
        }

        if (true) {
            Pairs o = new Pairs();
            int[] arr = {1, 5, 3, 4, 2};
            int k = 2;

            System.out.println("Result: " + o.pairs(k, arr));
        }

    }

    private int pairs(int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);

        int count = 0;
        for (int i : arr) {
            if (map.containsKey(i - k)) count += map.get(i - k);
        }

        return count;
    }

}
