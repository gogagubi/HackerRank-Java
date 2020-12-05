package com.hackerrank.interviewpreparation._08_search;

import java.util.Set;
import java.util.TreeSet;

public class MinimumTimeRequired {

    public static void main(String[] args) {
        if (true) {
            MinimumTimeRequired o = new MinimumTimeRequired();
            long[] machines = {2, 3};
            long goal = 5;

            System.out.println("Result: " + o.minTime(machines, goal)); //Expected 6
        }
    }

    private long minTime(long[] machines, long goal) {
        //Arrays.sort(machines);
        long min = 0, max = machines[machines.length - 1] * goal;
        long mid, candidate;
        long result = 0;

        while (min <= max) {
            candidate = 0;
            mid = min + (max - min) / 2;
            for (long machine : machines) {
                candidate += mid / machine;
            }

            if (candidate == goal) {
                result = mid;
                break;
            }

            if (candidate > goal) max = mid;
            else min = mid + 1;
        }

        return result;
    }

}
