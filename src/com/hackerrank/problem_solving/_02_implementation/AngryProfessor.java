package com.hackerrank.problem_solving._02_implementation;

public class AngryProfessor {

    public static void main(String[] args) {
        if (true) {
            AngryProfessor s = new AngryProfessor();
            int k = 3;
            int[] a = {-1, -3, 4, 2};

            System.out.println("Result = " + s.angryProfessor(k, a));
        }

        if (true) {
            AngryProfessor s = new AngryProfessor();
            int k = 2;
            int[] a = {0, -1, 2, 1};

            System.out.println("Result = " + s.angryProfessor(k, a));
        }
    }

    private String angryProfessor(int k, int[] a) {
        int count = 0;
        for(int i: a){
            if(i <= 0) count ++;
        }

        return count >= k ? "NO" : "YES";
    }

}
