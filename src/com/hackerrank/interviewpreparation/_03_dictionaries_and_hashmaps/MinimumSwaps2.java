package com.hackerrank.interviewpreparation._03_dictionaries_and_hashmaps;

import java.util.HashMap;
import java.util.Map;

public class MinimumSwaps2 {

    public static void main(String[] args) {
        if (true) {
            MinimumSwaps2 s = new MinimumSwaps2();
            String[] magazine = {"give", "me", "one", "grand", "today", "night"};
            String[] note = {"give", "one", "grand", "today"};

            s.checkMagazine(magazine, note);
        }

        if (true) {
            MinimumSwaps2 s = new MinimumSwaps2();
            String[] magazine = {"two", "times", "three", "is", "not", "four"};
            String[] note = {"two", "times", "two", "is", "four"};

            s.checkMagazine(magazine, note);
        }
    }

    public void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String m: magazine){
            map.put(m, map.getOrDefault(m, 0) + 1);
        }

        for(String n: note){
            int el = map.getOrDefault(n, 0);
            if(el == 0){
                System.out.println("No");
                return;
            }

            map.put(n, el - 1);
        }

        System.out.println("Yes");
    }

}
