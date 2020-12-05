package com.hackerrank.interviewpreparation._03_dictionaries_and_hashmaps;


import java.util.HashSet;
import java.util.Set;

public class SherlockandAnagrams {

    public static void main(String[] args) {
        if (true) {
            SherlockandAnagrams s = new SherlockandAnagrams();
            String s1 = "hello";
            String s2 = "world";

            System.out.println("Result " + s.twoStrings(s1, s2));
        }

        if (true) {
            SherlockandAnagrams s = new SherlockandAnagrams();
            String s1 = "hi";
            String s2 = "world";

            System.out.println("Result " + s.twoStrings(s1, s2));
        }
    }

    public String twoStrings(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s1.length(); i ++){
            set.add(s1.charAt(i));
        }

        for(int i = 0; i < s2.length(); i ++){
            if(set.contains(s2.charAt(i))){
                return "YES";
            }
        }

        return "NO";
    }

}
