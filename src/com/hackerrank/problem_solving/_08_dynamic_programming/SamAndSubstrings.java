package com.hackerrank.problem_solving._08_dynamic_programming;

public class SamAndSubstrings {

    public static void main(String[] args) {
        if (false) {
            SamAndSubstrings s = new SamAndSubstrings();
            String n = "16";

            System.out.println("Result = " + s.substrings(n));
        }

        if (false) {
            SamAndSubstrings s = new SamAndSubstrings();
            String n = "123";

            System.out.println("Result = " + s.substrings(n));
        }

        if (true) {
            SamAndSubstrings s = new SamAndSubstrings();
            String n = "972698438521";

            System.out.println("Result = " + s.substrings(n)); //expected: 445677619
        }
    }

    private int substrings(String n) {
        int mod = 1000000007;
        char[] s = n.toCharArray();

        long sum = 0;
        long ones = 1;
        for(int i = s.length - 1; i >= 0; i --){
            long res = ((i + 1) * (s[i] - '0') * ones) % mod;
            ones = (ones * 10 + 1) % mod;
            sum += res % mod;
        }

        return (int)(sum % mod);
    }

}
