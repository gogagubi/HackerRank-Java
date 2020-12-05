package com.hackerrank.problem_solving._07_greedy;

import java.util.Arrays;

public class MarcsCakewalk {

    public static void main(String[] args) {
        if (true) {
            MarcsCakewalk s = new MarcsCakewalk();
            int[] calorie = {7, 4, 9, 6};

            System.out.println("Result = " + s.marcsCakewalk(calorie));
        }

        if (true) {
            MarcsCakewalk s = new MarcsCakewalk();
            int[] calorie = {1, 3, 2};

            System.out.println("Result = " + s.marcsCakewalk(calorie));
        }

    }

    private long marcsCakewalk(int[] calorie) {
        Arrays.sort(calorie);
        int power = 0;
        long minMiles = 0;
        for (int i = calorie.length - 1; i >= 0; i--) {
            minMiles += Math.pow(2, power++) * calorie[i];
        }

        return minMiles;
    }

}
