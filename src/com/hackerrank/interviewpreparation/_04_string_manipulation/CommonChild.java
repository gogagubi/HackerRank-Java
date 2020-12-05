package com.hackerrank.interviewpreparation._04_string_manipulation;


public class CommonChild {

    public static void main(String[] args) {
        if (false) {
            CommonChild c = new CommonChild();
            String s1 = "HARRY";
            String s2 = "SALLY";

            System.out.println("Result " + c.commonChild(s1, s2));
        }

        if (false) {
            CommonChild c = new CommonChild();
            String s1 = "AA";
            String s2 = "BB";

            System.out.println("Result " + c.commonChild(s1, s2));
        }

        if (true) {
            CommonChild c = new CommonChild();
            String s1 = "SHINCHAN";
            String s2 = "NOHARAAA";

            System.out.println("Result " + c.commonChild(s1, s2)); //expected 3
        }
    }

    public int commonChild(String s1, String s2) {
        int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1; i <= s1.length(); i ++){
            for(int j = 1; j <= s2.length(); j ++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                }
                else{
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        return matrix[s1.length()][s2.length()];
    }

}
