package com.hackerrank.interviewpreparation._06_greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LuckBalance {

    public static void main(String[] args) {
        if (true) {
            LuckBalance c = new LuckBalance();
            int k = 3;
            int[][] arr = {
                    {5, 1},
                    {2, 1},
                    {1, 1},
                    {8, 1},
                    {10, 0},
                    {5, 0}
            };

            System.out.println("Result " + c.luckBalance(k, arr)); //expected 29
        }
    }

    private int luckBalance(int k, int[][] contests) {
        int total = 0;
        List<Integer> importantContents = new ArrayList<>();

        for (int i = 0; i < contests.length; i++) {
            int luck = contests[i][0];
            int importance = contests[i][1];

            total += luck;
            if (importance == 1) {
                importantContents.add(luck);
            }
        }

        int mustWin = importantContents.size() - k;
        Collections.sort(importantContents);
        int luckToDecrease = 0;
        for (int i = 0; i < mustWin; i++) {
            luckToDecrease += 2 * importantContents.get(i);
        }

        return total - luckToDecrease;
    }

}
