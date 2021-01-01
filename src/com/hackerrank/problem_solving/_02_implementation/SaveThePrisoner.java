package com.hackerrank.problem_solving._02_implementation;

public class SaveThePrisoner {

    public static void main(String[] args) {
        if (true) {
            SaveThePrisoner o = new SaveThePrisoner();
            int n = 5, m = 2, s = 1;

            System.out.println("Result = " + o.saveThePrisoner(n, m, s));
        }

        if (true) {
            SaveThePrisoner o = new SaveThePrisoner();
            int n = 7, m = 19, s = 2;

            System.out.println("Result = " + o.saveThePrisoner(n, m, s));
        }

        if (true) {
            SaveThePrisoner o = new SaveThePrisoner();
            int n = 3, m = 7, s = 3;

            System.out.println("Result = " + o.saveThePrisoner(n, m, s));
        }
    }

    private int saveThePrisoner(int n, int m, int s) {
        return (m - 1 + s - 1) % n + 1;
    }

}
