package com.hackerrank.interviewpreparation._08_search;

import java.util.HashMap;
import java.util.Map;

public class HashTablesIceCreamParlor {

    public static void main(String[] args) {
        if (true) {
            HashTablesIceCreamParlor o = new HashTablesIceCreamParlor();
            int[] cost = {1, 4, 5, 3, 2};
            int money = 4;

            System.out.print("Result: ");
            o.whatFlavors(cost, money);
        }

        if (true) {
            HashTablesIceCreamParlor o = new HashTablesIceCreamParlor();
            int[] cost = {2, 2, 4, 3};
            int money = 4;

            System.out.print("Result: ");
            o.whatFlavors(cost, money);
        }

    }

    private void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            int check = money - cost[i];
            if (map.containsKey(check)) {
                System.out.println(map.get(check) + " " + (i + 1));
                return;
            }
            map.put(cost[i], i + 1);
        }

    }

}
