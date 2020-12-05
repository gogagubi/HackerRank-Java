package com.hackerrank.interviewpreparation._05_sorting;

public class SortingComparator {

    public static void main(String[] args) {
        if (true) {
            SortingComparator c = new SortingComparator();
            Player a = new Player(55, "Soia");
            Player b = new Player(15, "Natalia");

            System.out.println("Result " + c.compare(a, b));
        }

        if (true) {
            SortingComparator c = new SortingComparator();
            Player a = new Player(55, "Soia");
            Player b = new Player(55, "Natalia");

            System.out.println("Result " + c.compare(a, b));
        }
    }

    private static class Player{
        public Player(){}
        public Player(int score, String name) {
            this.score = score;
            this.name = name;
        }

        private int score;
        private String name;
    }

    private int compare(Player a, Player b) {
        if(a.score < b.score) return 1;
        else if(a.score > b.score) return -1;
        return a.name.compareTo(b.name);
    }

}
