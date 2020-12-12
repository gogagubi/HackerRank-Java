package com.hackerrank.problem_solving._02_implementation;

public class BeautifulDaysAtTheMovies {

    public static void main(String[] args) {
        if (true) {
            BeautifulDaysAtTheMovies s = new BeautifulDaysAtTheMovies();
            int i = 20, j = 23, k = 6;

            System.out.println("Result = " + s.beautifulDays(i, j, k));
        }

        if (true) {
            BeautifulDaysAtTheMovies s = new BeautifulDaysAtTheMovies();
            int i = 13, j = 45, k = 3;

            System.out.println("Result = " + s.beautifulDays(i, j, k));
        }
    }

    private int beautifulDays(int i, int j, int k) {
        int ans = 0;
        for (int day = i; day <= j; day++) {
            int reversed = reverse(day);

            if ((day - reversed) % k == 0) {
                ans++;
            }
        }

        return ans;
    }

    private int reverse(int x) {
        int res = 0;
        while (x > 0) {
            int reminder = x % 10;
            res = (res * 10) + reminder;
            x /= 10;
        }

        return res;
    }
}
