package com.hackerrank._30_day_of_code;

public class Day_11_2DArrays {

    public static void main(String[] args) {
        if (true) {
            Day_11_2DArrays s = new Day_11_2DArrays();
            int[][] arr = {
                    {-9, -9, -9, 1, 1, 1},
                    {0, -9, 0, 4, 3, 2},
                    {-9, -9, -9, 1, 2, 3},
                    {0, 0, 8, 6, 6, 0},
                    {0, 0, 0, -2, 0, 0},
                    {0, 0, 1, 2, 4, 0}
            };

            System.out.print("Result = ");
            s.maxHourglassSum(arr);
            System.out.println();
        }
    }

    private void maxHourglassSum(int[][] arr) {
        int max = 7 * 9 * -1;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int candidate = arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
                        + arr[i + 1][j + 1]
                        + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max = Math.max(max, candidate);
            }
        }

        System.out.println(max);
    }

}
