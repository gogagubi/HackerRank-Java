package com.hackerrank.interviewpreparation._04_string_manipulation;


public class StringsMakingAnagrams {

    public static void main(String[] args) {
        if (true) {
            StringsMakingAnagrams c = new StringsMakingAnagrams();
            String a = "cde";
            String b = "abc";

            System.out.println("Result " + c.makeAnagram(a, b));
        }

        if (true) {
            StringsMakingAnagrams c = new StringsMakingAnagrams();
            String a = "fcrxzwscanmligyxyvym";
            String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

            System.out.println("Result " + c.makeAnagram(a, b));
        }
    }

    public int makeAnagram(String a, String b) {
        int count = 0;

        int[] aArr = new int[26];
        int[] bArr = new int[26];

        for(int i = 0; i < a.length(); i ++) aArr[a.charAt(i) - 'a'] ++;
        for(int i = 0; i < b.length(); i ++) bArr[b.charAt(i) - 'a'] ++;

        for(int i = 0; i < 26; i ++){
            if(aArr[i] > bArr[i]) count += aArr[i] - bArr[i];
            else if(bArr[i] > aArr[i]) count += bArr[i] - aArr[i];
        }

        return count;
    }

}
