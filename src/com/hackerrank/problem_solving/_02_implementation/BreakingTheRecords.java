package com.hackerrank.problem_solving._02_implementation;

import java.util.Arrays;
import java.util.List;

public class BreakingTheRecords {

    public static void main(String[] args) {
        if (true) {
            BreakingTheRecords s = new BreakingTheRecords();
            List<Integer> scores = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);

            System.out.println(s.breakingRecords(scores));
        }
    }

    public List<Integer> breakingRecords(List<Integer> scores) {
        int lowestScore = scores.get(0);
        int highestScore = scores.get(0);

        int highScoreBreaks = 0;
        int lowScoreBreaks = 0;

        for(int i = 1; i < scores.size(); i ++){
            int curr = scores.get(i);

            if(curr > highestScore) {
                highestScore = curr;
                highScoreBreaks ++;
            }

            if(curr < lowestScore){
                lowestScore = curr;
                lowScoreBreaks ++;
            }
        }

        return Arrays.asList(highScoreBreaks, lowScoreBreaks);
    }

}
