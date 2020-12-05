package com.hackerrank.interviewpreparation._04_string_manipulation;


import java.util.HashMap;
import java.util.Map;

public class SherlockAndTheValidString {

    public static void main(String[] args) {
        if (true) {
            SherlockAndTheValidString c = new SherlockAndTheValidString();
            String s = "aabbcd";

            System.out.println("Result " + c.isValid(s));
        }

        if (true) {
            SherlockAndTheValidString c = new SherlockAndTheValidString();
            String s = "abcdefghhgfedecba";

            System.out.println("Result " + c.isValid(s));
        }
    }

    public String isValid(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            arr[index]++;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > 0) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
        }

        if(map.size() > 2) return "NO";
        if(map.size() == 1) return "YES";
        if(map.containsKey(1) && map.get(1) == 1) return "YES";

        int count1 = 0, count2 = 0;
        for(int i: map.keySet()){
            if(count1 == 0) count1 = i;
            else count2 = i;
        }

        if(map.get(count1) > 1 && map.get(count2) > 1) return "NO";
        if(Math.abs(count1 - count2) == 1) return "YES";
        return "NO";
    }

}
