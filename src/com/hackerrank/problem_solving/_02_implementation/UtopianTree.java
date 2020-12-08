package com.hackerrank.problem_solving._02_implementation;

public class UtopianTree {

    public static void main(String[] args) {
        if (true) {
            UtopianTree s = new UtopianTree();
            int n = 5;

            System.out.println("Result = " + s.utopianTree(n));
        }
    }

    private int utopianTree(int n) {
        int ans = 0;
        int period = 0;
        while (period <= n) {
            if (period % 2 == 0) ans += 1;
            else ans *= 2;

            period++;
        }

        return ans;
    }

}
