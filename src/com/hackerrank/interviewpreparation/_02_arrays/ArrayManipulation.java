package com.hackerrank.interviewpreparation._02_arrays;

public class ArrayManipulation {

    public static void main(String[] args) {
        if (true) {
            ArrayManipulation s = new ArrayManipulation();
            int n = 10;
            int[][] queries = {
                    {1, 5, 3},
                    {4, 8, 7},
                    {6, 9, 1},
            };

            System.out.println("Result: " + s.arrayManipulation(n, queries));
        }

        if (true) {
            ArrayManipulation s = new ArrayManipulation();
            int n = 4;
            int[][] queries = {
                    {2, 3, 603},
                    {1, 1, 286},
                    {4, 4, 882},
            };

            System.out.println("Result: " + s.arrayManipulation(n, queries));
        }
    }

    public long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1];
        int a, b, k;
        for(int i = 0; i < queries.length; i ++){
            a = queries[i][0];
            b = queries[i][1];
            k = queries[i][2];

            arr[a] += k;
            if(b < n) arr[b + 1] -= k;
        }

        long sum = 0, max = 0;
        for(int i = 1; i < arr.length; i ++){
            sum += arr[i];
            max = Math.max(max, sum);
        }

        return max;
    }

}
