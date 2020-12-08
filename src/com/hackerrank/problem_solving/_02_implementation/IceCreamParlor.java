package com.hackerrank.problem_solving._02_implementation;

import java.util.*;

public class IceCreamParlor {

    public static void main(String[] args) {
        if (true) {
            IceCreamParlor s = new IceCreamParlor();
            int m = 4;
            int[] arr = {1, 4, 5, 3, 2};

            System.out.println("Result = " + Arrays.toString(s.icecreamParlor(m, arr)));
        }

        if (true) {
            IceCreamParlor s = new IceCreamParlor();
            int m = 4;
            int[] arr = {2, 2, 4, 3};

            System.out.println("Result = " + Arrays.toString(s.icecreamParlor(m, arr)));
        }
    }

    private int[] icecreamParlor(int m, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i ++){
            if(map.containsKey(m - arr[i])){
                return new int[]{map.get(m - arr[i]) + 1, i + 1};
            }
            map.put(arr[i], i);
        }

        return null;
    }


    //n^2 Solution
    private int[] icecreamParlor1(int m, int[] arr) {
        int N = arr.length;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] + arr[j] == m) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return null;
    }

}
