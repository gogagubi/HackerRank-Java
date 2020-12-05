package com.hackerrank.interviewpreparation._02_arrays;

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

    }

    private List<Integer> rotateLeft(int d, List<Integer> arr) {
        int N = arr.size();
        d = d % N;

        int[] rotElm = new int[d];
        for (int i = 0; i < d; i++) rotElm[i] = arr.get(i);

        for (int i = 0; i < N - d; i++) arr.set(i, arr.get(i + d));

        for (int i = rotElm.length - 1; i >= 0; i--) {
            arr.set(--N, rotElm[i]);
        }

        return arr;
    }

}
