package com.hackerrank.problem_solving._06_graph_theory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLaddersTheQuickestWayUp {

    public static void main(String[] args) {
        SnakesAndLaddersTheQuickestWayUp o = new SnakesAndLaddersTheQuickestWayUp();

        //Test Case 0
        if (true) {
            o.runTestCase("in/problem_solving/_06_graph_theory/SnakesAndLaddersTheQuickestWayUp_TestCase0");
            //expected
            //3
            //5
        }

        //Test Case 1
        if (true) {
            o.runTestCase("in/problem_solving/_06_graph_theory/SnakesAndLaddersTheQuickestWayUp_TestCase1");
            //expected
            //3
            //2
            //2
        }

        //Test Case 3
        if (true) {
            o.runTestCase("in/problem_solving/_06_graph_theory/SnakesAndLaddersTheQuickestWayUp_TestCase3");
            //expected
            //-1
        }

    }

    private void runTestCase(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            int t = Integer.valueOf(in.readLine());

            for (int i = 0; i < t; i++) {
                int n = Integer.valueOf(in.readLine());

                int[][] ladders = new int[n][2];
                for (int j = 0; j < n; j++) {
                    String[] line = in.readLine().split(" ");
                    ladders[j] = new int[]{Integer.valueOf(line[0]), Integer.valueOf(line[1])};
                }

                int m = Integer.valueOf(in.readLine());

                int[][] snakes = new int[m][2];
                for (int j = 0; j < m; j++) {
                    String[] line = in.readLine().split(" ");
                    snakes[j] = new int[]{Integer.valueOf(line[0]), Integer.valueOf(line[1])};
                }

                int ans = quickestWayUp(ladders, snakes);
                System.out.println(ans);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int quickestWayUp(int[][] ladders, int[][] snakes) {
        int n = 100;

        int[] routes = new int[n + 1];
        for (int i = 0; i < ladders.length; i++) routes[ladders[i][0]] = ladders[i][1];
        for (int i = 0; i < snakes.length; i++) routes[snakes[i][0]] = snakes[i][1];

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int[] curr = {1, 0};
        queue.add(curr);

        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (curr[0] == n) break;

            for (int i = curr[0] + 1; i <= curr[0] + 6 && i <= n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    int[] entry = new int[2];
                    entry[1] = curr[1] + 1;

                    if (routes[i] == 0) entry[0] = i;
                    else entry[0] = routes[i];
                    queue.add(entry);
                }
            }
        }

        return curr[0] == 100 ? curr[1] : -1;
    }

}
