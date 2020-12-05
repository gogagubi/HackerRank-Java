package com.hackerrank.interviewpreparation._02_arrays;

import java.util.Arrays;

public class NewYearChaos {

    public static void main(String[] args) {
        if (true) {
            NewYearChaos s = new NewYearChaos();
            int[] q = {2, 1, 5, 3, 4};

            s.minimumBribes(q);//Expected: 3
            System.out.println();
        }

        if (false) {
            NewYearChaos s = new NewYearChaos();
            int[] q = {2, 5, 1, 3, 4};

            s.minimumBribes(q);// Expected: Too chaotic
            System.out.println();
        }

        if (false) {
            NewYearChaos s = new NewYearChaos();
            int[] q = {5, 1, 2, 3, 7, 8, 6, 4};

            s.minimumBribes(q); //Expected: Too chaotic
            System.out.println();
        }

        if (false) {
            NewYearChaos s = new NewYearChaos();
            int[] q = {1, 2, 5, 3, 7, 8, 6, 4};

            s.minimumBribes(q); //Expected: 7
            System.out.println();
        }
    }

    //Mathematical count
    private void minimumBribes(int[] q) {
        int bribes = 0;
        int prev = q.length;

        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - i > 3) {
                System.out.println("Too chaotic");
                return;
            }
            if (q[i] > i + 1) {
                bribes += (q[i] - (i + 1));
            } else {
                if (prev > q[i]) {
                    prev = q[i];
                } else if (prev < q[i]) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    //Swaping
    public void minimumBribes1(int[] q){
        int bribes = 0;
        for(int i = q.length - 1; i > 0; i --){
            if(q[i] != (i + 1)){
                if(q[i - 1] == (i + 1)){
                    int tmp = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = tmp;
                    bribes ++;
                }
                else if(i > 1 && q[i - 2] == (i + 1)){
                    int tmp = q[i - 2];
                    q[i - 2] = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = tmp;
                    bribes += 2;
                }
                else{
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(bribes);
    }

}
