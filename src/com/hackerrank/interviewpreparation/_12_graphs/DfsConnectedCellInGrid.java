package com.hackerrank.interviewpreparation._12_graphs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class DfsConnectedCellInGrid {

    public static void main(String[] args) {
        DfsConnectedCellInGrid o = new DfsConnectedCellInGrid();

        //Test Case 0
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/DfsConnectedCellInGrid_TestCase0");
        }

        //Test Case 1
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/DfsConnectedCellInGrid_TestCase1");
        }

        //Test Case 2
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/DfsConnectedCellInGrid_TestCase2");
        }
    }


    private void runTestCase(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            int n = Integer.valueOf(in.readLine());
            int m = Integer.valueOf(in.readLine());

            int[][] graph = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] row = in.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    graph[i][j] = Integer.valueOf(row[j]);
                }
            }

            int res = maxRegion(graph);
            System.out.println(res);

            in.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private int maxRegion(int[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        int count = 0;
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] == 0) return count;

        grid[i][j] = 0;

        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i + 1, j);

        //on zig-zag
        count += dfs(grid, i + 1, j + 1);
        count += dfs(grid, i - 1, j + 1);
        count += dfs(grid, i - 1, j - 1);
        count += dfs(grid, i + 1, j - 1);

        return count + 1;
    }
}
