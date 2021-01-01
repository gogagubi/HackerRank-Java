package com.hackerrank.interviewpreparation._02_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {

    public static void main(String[] args) {
        if (true) {
            LeftRotation s = new LeftRotation();
            List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
            int d = 4;

            System.out.println("Result = " + s.rotateLeft(d, arr));
        }

        if (true) {
            LeftRotation s = new LeftRotation();
            List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
            int d = 7;

            System.out.println("Result = " + s.rotateLeft(d, arr));
        }

    }

    private List<Integer> rotateLeft(int d, List<Integer> arr) {
        int n = arr.size();
        int[] rotated = new int[n];
        d %= n;
        for(int i = 0; i < n; i ++){
            rotated[(i + n - d) % n] = arr.get(i);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i: rotated) ans.add(i);

        return ans;
    }

}
