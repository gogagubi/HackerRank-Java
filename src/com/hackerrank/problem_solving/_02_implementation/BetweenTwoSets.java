package com.hackerrank.problem_solving._02_implementation;

import java.util.Arrays;
import java.util.List;

public class BetweenTwoSets {

    public static void main(String[] args) {
        if (true) {
            BetweenTwoSets s = new BetweenTwoSets();
            List<Integer> a = Arrays.asList(2, 6);
            List<Integer> b = Arrays.asList(24, 36);

            System.out.println("Result = " + s.getTotalX(a, b));
        }

        if (true) {
            BetweenTwoSets s = new BetweenTwoSets();
            List<Integer> a = Arrays.asList(2, 3);
            List<Integer> b = Arrays.asList(16, 32, 96);

            System.out.println("Result = " + s.getTotalX(a, b));
        }

    }

    public int getTotalX(List<Integer> a, List<Integer> b) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i: a) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        for(int i: b){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int ans = 0;
        for(int i = min; i <= max; i ++){
            int matches = 0;
            for(int j: a) {
                if(i >= j && i % j == 0) matches ++;
            }

            for(int j: b){
                if(j >= i && j % i == 0) matches ++;
            }

            if(matches == a.size() + b.size()) ans ++;
        }

        return ans;
    }

}
