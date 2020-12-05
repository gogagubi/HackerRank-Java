package com.hackerrank._30_day_of_code;

public class Day_10_BinaryNumbers {

    public static void main(String[] args) {
        if (true) {
            Day_10_BinaryNumbers s = new Day_10_BinaryNumbers();
            int n = 5;

            System.out.print("Result = ");
            s.numberOfConsecutiveOne(n);
            System.out.println();
        }

        if (true) {
            Day_10_BinaryNumbers s = new Day_10_BinaryNumbers();
            int n = 6;

            System.out.print("Result = ");
            s.numberOfConsecutiveOne(n);
            System.out.println();
        }

        if (true) {
            Day_10_BinaryNumbers s = new Day_10_BinaryNumbers();
            int n = 439;

            System.out.print("Result = ");
            s.numberOfConsecutiveOne(n);
            System.out.println();
        }
    }

    private void numberOfConsecutiveOne(int n) {
        int result = 0;
        int count = 0;
        while (n > 0) {
            int candidate = n % 2;
            if (candidate == 1) count++;
            else {
                result = Math.max(result, count);
                count = 0;
            }

            n /= 2;
        }

        System.out.println(Math.max(result, count));
    }

}
