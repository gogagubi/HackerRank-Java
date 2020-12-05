package com.hackerrank.interviewpreparation._06_greedy_algorithms;


public class ReverseShuffleMerge {

    public static void main(String[] args) {
        if (false) {
            ReverseShuffleMerge o = new ReverseShuffleMerge();
            String s = "abab";

            String result = o.reverseShuffleMerge(s);
            System.out.println("Result: " + result + " Correct: " + result.equals("ab"));
        }

        if (true) {
            ReverseShuffleMerge o = new ReverseShuffleMerge();
            String s = "eggegg";

            String result = o.reverseShuffleMerge(s);
            System.out.println("Result: " + result + " Correct: " + result.equals("egg"));
        }

        if (true) {
            ReverseShuffleMerge o = new ReverseShuffleMerge();
            String s = "abcdefgabcdefg";

            String result = o.reverseShuffleMerge(s);
            System.out.println("Result: " + result + " Correct: " + result.equals("agfedcb"));
        }

        if (true) {
            ReverseShuffleMerge o = new ReverseShuffleMerge();
            String s = "djjcddjggbiigjhfghehhbgdigjicafgjcehhfgifadihiajgciagicdahcbajjbhifjiaajigdgdfhdiijjgaiejgegbbiigida";

            String result = o.reverseShuffleMerge(s);
            System.out.println("Result: " + result + " Correct: " + result.equals("aaaaabccigicgjihidfiejfijgidgbhhehgfhjgiibggjddjjd"));
        }

        if (true) {
            ReverseShuffleMerge o = new ReverseShuffleMerge();
            String s = "sbcnzxqnrygkocahxjebvueaawwcythjdrhvizqsshgtwdolmillxpshxpxqrywkivceufclhydhshrklkphajbftuapiocjlcthfirhgaohfysqjolssbzhbovdstbyqdpnjbpfmgqrzfctcwcrztvgbegunarvecseoulabaonguckqbtrvuagreyclyjytpvozqdnhldlnsocenuzksawirgsbjobpldjdlrxbricrauuksbmecvvwagnnacaqghmjpzrlsvlpbbcuaddgvlhvuvkxexjcfhxrodmcwlrzyyiksuksshhonahsyzbbprwuitmoyoqurtqsaslevgvpfbzkkhgcnpjdpseuiylluvdetsqssbrxpiclxxvosuqipsqvvwsezhl";

            String result = o.reverseShuffleMerge(s);
            System.out.println("Result: " + result + " Correct: " + result.equals("aaaaaavvcembskuabxddlpbbsgiaskucosdlhndqzovpjlcyerauvrbcugnbluescevrnubgvtzrcwccfzrqgmfpbjnpdqybtsdvobhzsslojqsyfhoghrifhtclcoiputjhpklkrhsdyhlcuevikwyrqxpxhspxllimlowtghssqzivhrjtywweuvejxokgyrnqxzns"));
        }
    }

    private String reverseShuffleMerge(String s) {
        int alphaSize = 26;
        int[] counts = new int[alphaSize];
        int[] used = new int[alphaSize];
        int[] required = new int[alphaSize];

        for (int i = 0; i < s.length(); i++) counts[s.charAt(i) - 'a']++;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) required[i] = counts[i] / 2;
        }

        int ind = 0;
        char[] buffer = new char[s.length() / 2];

        for (int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);
            int ascii = curr - 'a';

            if (used[ascii] < required[ascii]) {
                while (ind > 0 && buffer[ind - 1] > curr
                        && used[buffer[ind - 1] - 'a'] + counts[buffer[ind - 1] - 'a']
                        > required[buffer[ind - 1] - 'a']) {
                    used[buffer[ind - 1] - 'a']--;
                    ind--;
                }

                buffer[ind++] = curr;
                used[ascii]++;
            }

            counts[ascii]--;
        }

        return new String(buffer);
    }

}
