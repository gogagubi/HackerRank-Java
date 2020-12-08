package com.hackerrank.problem_solving._02_implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheSticks {

    public static void main(String[] args) {
        if (true) {
            CutTheSticks s = new CutTheSticks();
            int[] arr = {1, 2, 3};

            System.out.println("Result = " + Arrays.toString(s.cutTheSticks(arr)));
        }

        if (true) {
            CutTheSticks s = new CutTheSticks();
            int[] arr = {5, 4, 4, 2, 2, 8};

            System.out.println("Result = " + Arrays.toString(s.cutTheSticks(arr)));
        }

        if (true) {
            CutTheSticks s = new CutTheSticks();
            int[] arr = {1, 2, 3, 4, 3, 3, 2, 1};

            System.out.println("Result = " + Arrays.toString(s.cutTheSticks(arr)));
        }
    }

    private int[] cutTheSticks(int[] arr) {
        int N = arr.length;
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) {
                list.add(N - i);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

}
