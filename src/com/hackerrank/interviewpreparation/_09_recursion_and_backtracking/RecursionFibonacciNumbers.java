package com.hackerrank.interviewpreparation._09_recursion_and_backtracking;

public class RecursionFibonacciNumbers {

    public static void main(String[] args) {
        if (true) {
            RecursionFibonacciNumbers o = new RecursionFibonacciNumbers();
            int n = 4;

            System.out.println("Result: " + o.fibonacci(n));
        }

        if (true) {
            RecursionFibonacciNumbers o = new RecursionFibonacciNumbers();
            int n = 6;

            System.out.println("Result: " + o.fibonacci(n));
        }
    }

    private int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

}
