package com.hackerrank.interviewpreparation._02_arrays;

public class MinimumSwaps2 {

    public static void main(String[] args) {
        if (true) {
            MinimumSwaps2 s = new MinimumSwaps2();
            int[] arr = {7, 1, 3, 2, 4, 5, 6};

            System.out.println("Result: " + s.minimumSwaps(arr));
        }
    }

    public int minimumSwaps(int[] arr) {
        int swaps = 0;
        int i = 0;
        while(i < arr.length) {
            if (arr[i] != i + 1) {
                int tmp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[tmp - 1] = tmp;

                swaps ++;
            }
            else i ++;
        }

        return swaps;
    }

}
