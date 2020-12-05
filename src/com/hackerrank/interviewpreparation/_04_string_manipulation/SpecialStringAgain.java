package com.hackerrank.interviewpreparation._04_string_manipulation;


import java.util.ArrayList;
import java.util.List;

public class SpecialStringAgain {

    public static void main(String[] args) {
        if (true) {
            SpecialStringAgain c = new SpecialStringAgain();
            String s = "mnonopoo";

            System.out.println("Result " + c.substrCount(s.length(), s)); //expected 12
        }

        if (true) {
            SpecialStringAgain c = new SpecialStringAgain();
            String s = "asasd";

            System.out.println("Result " + c.substrCount(s.length(), s)); //expected 7
        }

        if (true) {
            SpecialStringAgain c = new SpecialStringAgain();
            String s = "abcbaba";

            System.out.println("Result " + c.substrCount(s.length(), s)); //expected 10
        }

        if (true) {
            SpecialStringAgain c = new SpecialStringAgain();
            String s = "aaaa";

            System.out.println("Result " + c.substrCount(s.length(), s)); //expected 10
        }
    }

    private static class Pair {
        private Pair(char key, int value) {
            this.key = key;
            this.value = value;
        }

        private char key;
        private int value;
    }

    public long substrCount(int n, String s) {
        List<Pair> list = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                list.add(new Pair(s.charAt(i), count));
                count = 0;
            }
        }

        long result = 0;

        //avoid iterations and use formula for same characters in string
        for (Pair p : list) {
            result += (p.value * (p.value + 1)) / 2;
        }

        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i - 1).key == list.get(i + 1).key && list.get(i).value == 1) {
                result += Math.min(list.get(i - 1).value, list.get(i + 1).value);
            }
        }

        return result;
    }

}
