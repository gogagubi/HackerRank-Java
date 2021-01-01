package com.hackerrank.problem_solving._08_dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class TheCoinChangeProblem {

    public static void main(String[] args) {
        if (true) {
            TheCoinChangeProblem s = new TheCoinChangeProblem();
            List<Long> c = Arrays.asList(1L, 2L, 3L);
            int n = 4;

            System.out.println("Result = " + s.getWays(n, c));
        }

        if (true) {
            TheCoinChangeProblem s = new TheCoinChangeProblem();
            List<Long> c = Arrays.asList(8L, 3L, 1L, 2L);
            int n = 4;

            System.out.println("Result = " + s.getWays(n, c));
        }

        if (true) {
            TheCoinChangeProblem s = new TheCoinChangeProblem();
            List<Long> c = Arrays.asList(2L, 5L, 3L, 6L);
            int n = 10;

            System.out.println("Result = " + s.getWays(n, c));
        }
    }

    private long getWays(int n, List<Long> c){
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for(long coin : c){
            for(int i = (int)coin; i <= n; i++){
                dp[i] += dp[i - (int)coin];
            }
        }
        return dp[n];
    }

    private long getWays1(int n, List<Long> c) {
        int size = c.size();
        long[][] A = new long[size][n + 1];

        for (int i = 0; i < size; i++) {
            A[i][0] = 1;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= n; j++) {
                long x = (i > 0) ? A[i - 1][j] : 0;
                long y = (j - c.get(i) >= 0) ? A[i][j - c.get(i).intValue()] : 0;
                A[i][j] = x + y;
            }
        }

        return A[c.size() - 1][n];
    }

}
