package com.hackerrank.interviewpreparation._02_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {

    public static void main(String[] args) {
        if (true) {
            DynamicArray s = new DynamicArray();
            List<List<Integer>> queries = Arrays.asList(
                    Arrays.asList(1, 0, 5),
                    Arrays.asList(1, 1, 7),
                    Arrays.asList(1, 0, 3),
                    Arrays.asList(2, 1, 0),
                    Arrays.asList(2, 1, 1)
            );
            int n = 5;

            System.out.println("Result = " + s.dynamicArray(n, queries));
        }

    }

    private List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<Integer> result = new ArrayList<>();
        List<Integer>[] seqList = new ArrayList[n];

        for (int i = 0; i < seqList.length; i++)
            seqList[i] = new ArrayList<>();

        int m = queries.size();
        for (int i = 0; i < m; i++) {
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            int k = (x ^ lastAnswer) % n;

            if (queries.get(i).get(0) == 2) {
                lastAnswer = seqList[k].get(y % seqList[k].size());
                result.add(lastAnswer);
            } else {
                seqList[k].add(y);
            }
        }

        return result;
    }

}
