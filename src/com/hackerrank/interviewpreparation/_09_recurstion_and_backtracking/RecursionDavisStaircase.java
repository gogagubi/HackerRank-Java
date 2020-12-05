package com.hackerrank.interviewpreparation._09_recurstion_and_backtracking;

import java.util.HashMap;
import java.util.Map;

public class RecursionDavisStaircase {

    public static void main(String[] args) {
        if (true) {
            RecursionDavisStaircase o = new RecursionDavisStaircase();
            int n = 7;

            System.out.println("Result: " + o.stepPerms(n));
        }
    }

    private static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 4);
    }

    private int stepPerms(int n) {
        if (map.containsKey(n)) return map.get(n);

        int res = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3);
        map.put(n, res);
        return res;
    }
}
