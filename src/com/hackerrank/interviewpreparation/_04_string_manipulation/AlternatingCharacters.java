package com.hackerrank.interviewpreparation._04_string_manipulation;


public class AlternatingCharacters {

    public static void main(String[] args) {
        if (true) {
            AlternatingCharacters c = new AlternatingCharacters();
            String s = "AAAA";

            System.out.println("Result " + c.alternatingCharacters(s));
        }

        if (true) {
            AlternatingCharacters c = new AlternatingCharacters();
            String s = "ABABABAB";

            System.out.println("Result " + c.alternatingCharacters(s));
        }

        if (true) {
            AlternatingCharacters c = new AlternatingCharacters();
            String s = "AAABBB";

            System.out.println("Result " + c.alternatingCharacters(s));
        }
    }

    public int alternatingCharacters(String s) {
        int count = 0;
        for(int i = 0; i < s.length() - 1; i ++){
            if(s.charAt(i) == s.charAt(i + 1)) count ++;
        }

        return count;
    }

}
