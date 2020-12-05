package com.hackerrank.interviewpreparation._02_arrays;

import java.util.Arrays;

public class ArraysDS {

    public static void main(String[] args) {
        if (true) {
            ArraysDS s = new ArraysDS();
            int[] a = {1, 4, 3, 2};

            System.out.println("Result = " + Arrays.toString(s.reverseArray(a)));
        }

    }

    private int[] reverseArray(int[] a) {
        int l = 0, r = a.length - 1;

        while(l < r){
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;

            l ++;
            r --;
        }

        return a;
    }

}
