package com.hackerrank.interviewpreparation._08_search;

public class MakingCandies {

    public static void main(String[] args) {
        if (false) {
            MakingCandies o = new MakingCandies();
            long m = 1, w = 2, p = 1, n = 60;

            System.out.println("Result: " + o.minimumPasses(m, w, p, n)); //Expected 4
        }

        if (true) {
            MakingCandies o = new MakingCandies();
            long m = 1, w = 1, p = 6, n = 45;

            System.out.println("Result: " + o.minimumPasses(m, w, p, n)); //Expected 16
        }

        if (false) {
            MakingCandies o = new MakingCandies();
            long m = 123456789012L, w = 215987654321L, p = 50000000000L, n = 1000000000000L;

            System.out.println("Result: " + o.minimumPasses(m, w, p, n)); //Expected 1
        }
    }

    private long minimumPasses(long m, long w, long p, long n) {
        long passes = 0;
        long candy = 0;
        long spend = Long.MAX_VALUE;
        long step;

        while (candy < n) {
            step = (m > Long.MAX_VALUE / w) ? 0 : (p - candy) / (m * w);

            if (step <= 0) {
                long resources = candy / p;

                long gap = Math.min(resources, Math.abs(m - w));
                resources -= gap;

                if(m > w) w += gap;
                else m += gap;

                m += resources / 2;
                w += (resources - (resources/2));

                candy %= p;
                step = 1;
            }

            passes += step;

            if (step * m > Long.MAX_VALUE / w) {
                candy = Long.MAX_VALUE;
            } else {
                candy += step * m * w;
                spend = Math.min(spend, (long) (passes + Math.ceil((n - candy) / (double) (m * w))));
            }
        }

        return Math.min(passes, spend);
    }
}
