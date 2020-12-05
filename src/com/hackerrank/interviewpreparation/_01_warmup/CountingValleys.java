package com.hackerrank.interviewpreparation._01_warmup;

public class CountingValleys {

    public static void main(String[] args) {
        if (true) {
            CountingValleys s = new CountingValleys();
            String path = "UDDDUDUU";

            System.out.println("Result = " + s.countingValleys(path.length(), path));
        }

        if (true) {
            CountingValleys s = new CountingValleys();
            String path = "DDUUUUDD";

            System.out.println("Result = " + s.countingValleys(path.length(), path));
        }
    }

    private int countingValleys(int steps, String path) {
        int trackBefore = 0, track = 0;
        int valleys = 0;

        for(int i = 0; i < path.length(); i ++){
            track += (path.charAt(i) == 'U' ? 1 : -1);

            if(track == 0 && trackBefore < 0) valleys += 1;
            trackBefore = track;
        }

        return valleys;
    }

}
