package com.hackerrank.interviewpreparation._03_dictionaries_and_hashmaps;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoStrings {

    public static void main(String[] args) {
        if (true) {
            TwoStrings c = new TwoStrings();
            String s = "abba";

            System.out.println("Result " + c.sherlockAndAnagrams(s));
        }

        if (false) {
            TwoStrings c = new TwoStrings();
            String s = "abcd";

            System.out.println("Result " + c.sherlockAndAnagrams(s));
        }

        if (false) {
            TwoStrings c = new TwoStrings();
            String s = "ifailuhkqq";

            System.out.println("Result " + c.sherlockAndAnagrams(s));
        }
    }

    public int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();
        char[] arr;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                arr = s.substring(i, j + 1).toCharArray();
                Arrays.sort(arr);
                String sub = new String(arr);

                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }

        int anagramPairs = 0;
        for (String key : map.keySet()) {
            int n = map.get(key);
            anagramPairs += n * (n - 1) / 2;
        }

        return anagramPairs;
    }

}
