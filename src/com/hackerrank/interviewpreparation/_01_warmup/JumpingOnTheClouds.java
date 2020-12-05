package com.hackerrank.interviewpreparation._01_warmup;

public class JumpingOnTheClouds {

    public static void main(String[] args) {
        if (true) {
            JumpingOnTheClouds s = new JumpingOnTheClouds();
            int[] c = {0, 0, 1, 0, 0, 1, 0};

            System.out.println("Result = " + s.jumpingOnClouds(c));
        }


        if (true) {
            JumpingOnTheClouds s = new JumpingOnTheClouds();
            int[] c = {0, 1, 0, 0, 0, 1, 0};

            System.out.println("Result = " + s.jumpingOnClouds(c));
        }
    }

    private int jumpingOnClouds(int[] c) {
        int pos = 0, steps = 0;

        while (pos < c.length - 1) {
            if (pos < c.length - 2 && c[pos + 2] == 0) pos += 2;
            else pos += 1;
            steps++;
        }

        return steps;
    }

}
