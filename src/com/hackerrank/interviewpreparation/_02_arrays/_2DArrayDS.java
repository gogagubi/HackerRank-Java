package com.hackerrank.interviewpreparation._02_arrays;

public class _2DArrayDS {

    public static void main(String[] args) {
        if (true) {
            _2DArrayDS s = new _2DArrayDS();
            int[][] arr = {
                    {-9, -9, -9, 1, 1, 1},
                    {0, -9, 0, 4, 3, 2},
                    {-9, -9, -9, 1, 2, 3},
                    {0, 0, 8, 6, 6, 0},
                    {0, 0, 0, -2, 0, 0},
                    {0, 0, 1, 2, 4, 0}
            };

            System.out.println("Result = " + s.hourglassSum(arr));
        }

    }

    private int hourglassSum(int[][] arr) {
        int curr, sum = -63;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                curr = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                        arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                sum = Math.max(sum, curr);
            }
        }

        return sum;
    }

}
