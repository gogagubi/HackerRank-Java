package com.hackerrank.problem_solving._12_game_theory;


public class GameOfStones {

    public static void main(String[] args) {
        if (true) {
            GameOfStones o = new GameOfStones();
            int n = 1;
            System.out.println(o.gameOfStones(n));
        }

        if (true) {
            GameOfStones o = new GameOfStones();
            int n = 2;
            System.out.println(o.gameOfStones(n));
        }

        if (true) {
            GameOfStones o = new GameOfStones();
            int n = 7;
            System.out.println(o.gameOfStones(n));
        }

        if (true) {
            GameOfStones o = new GameOfStones();
            int n = 10;
            System.out.println(o.gameOfStones(n));
        }
    }


    private String gameOfStones(int n) {
        return (n % 7 == 0 || n % 7 == 1) ? "Second" : "First";
    }
}
