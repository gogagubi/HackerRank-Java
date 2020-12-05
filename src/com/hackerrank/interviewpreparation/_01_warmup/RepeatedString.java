package com.hackerrank.interviewpreparation._01_warmup;

public class RepeatedString {

    public static void main(String[] args) {
        if (true) {
            RepeatedString ob = new RepeatedString();
            String s = "abcac";
            long n = 10;

            System.out.println("Result = " + ob.repeatedString(s, n));
        }

    }

    private long repeatedString(String s, long n) {
        long count = 0;
        int[] history = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) history[i] = history[i - 1];
            if (s.charAt(i) == 'a') {
                count++;
                history[i]++;
            }
        }

        count *= n / s.length();
        if (n % s.length() != 0) {
            count += history[(int) (n % s.length() - 1)];
        }

        return count;
    }

}
