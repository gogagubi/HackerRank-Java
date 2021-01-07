package com.hackerrank.problem_solving._02_implementation;

public class NumberLineJumps {

    public static void main(String[] args) {
        if (true) {
            NumberLineJumps s = new NumberLineJumps();
            int x1 = 0, v1 = 2, x2 = 5, v2 = 3;

            String result = s.kangaroo(x1, v1, x2, v2);
            System.out.println("Result " + result);
        }

        if (true) {
            NumberLineJumps s = new NumberLineJumps();
            int x1 = 0, v1 = 3, x2 = 4, v2 = 2;

            String result = s.kangaroo(x1, v1, x2, v2);
            System.out.println("Result " + result);
        }
    }

    private String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 > v2) {

            int remainder = (x1 - x2) % (v2 - v1);

            if (remainder == 0) {
                return "YES";
            }
        }
        return "NO";
    }

}
