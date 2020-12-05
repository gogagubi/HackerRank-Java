package com.hackerrank.interviewpreparation._02_arrays;

import java.util.Arrays;

public class ArraysLeftRotation {

    public static void main(String[] args) {
        if (true) {
            ArraysLeftRotation s = new ArraysLeftRotation();
            int[] a = {1, 2, 3, 4, 5};
            int d = 4;

            System.out.println("Result = " + Arrays.toString(s.rotLeft(a, d)));
        }

    }

    private int[] rotLeft(int[] a, int d) {
        int N = a.length;
        d = d % N;

        int[] rotElm = new int[d];
        for (int i = 0; i < d; i++) rotElm[i] = a[i];

        for (int i = 0; i < a.length - d; i++) a[i] = a[i + d];

        for (int i = rotElm.length - 1; i >= 0; i--) {
            a[--N] = rotElm[i];
        }

        return a;
    }

}
