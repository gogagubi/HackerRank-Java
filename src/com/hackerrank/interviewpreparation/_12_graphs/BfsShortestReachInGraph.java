package com.hackerrank.interviewpreparation._12_graphs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BfsShortestReachInGraph {

    public static void main(String[] args) {
        BfsShortestReachInGraph o = new BfsShortestReachInGraph();

        //Test Case 0
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/BfsShortestReachInGraph_TestCase0");
        }

    }


    private void runTestCase(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            int q = Integer.valueOf(in.readLine());
            for (int t = 0; t < q; t++) {
                String[] line = in.readLine().split(" ");
                int n = Integer.valueOf(line[0]);
                int m = Integer.valueOf(line[1]);

                int[][] graph = new int[m][2];

                for (int i = 0; i < m; i++) {
                    line = in.readLine().split(" ");
                    graph[i] = new int[]{Integer.valueOf(line[0]), Integer.valueOf(line[1])};
                }

                int s = Integer.valueOf(in.readLine());

                int[] res = shortestReach(n, graph, s);
                for (int i = 0; i < res.length; i++) {
                    System.out.print(res[i]);
                    if (i != res.length - 1) System.out.print(" ");
                }
                System.out.println();
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private int[] shortestReach(int n, int[][] graph, int s) {
        Map<Integer, List<Integer>> routes = buildRoutes(graph);

        HashMap<Integer, Integer> values = new HashMap<>();
        values.put(s, 0);

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr]) continue;
            visited[curr] = true;

            if (!routes.containsKey(curr)) continue;

            for (int i : routes.get(curr)) {
                if (visited[i]) continue;

                int destValue = values.getOrDefault(curr, 0) + 6;
                if (values.containsKey(i)) destValue = Math.min(destValue, values.get(i));
                values.put(i, destValue);

                queue.add(i);
            }
        }

        int j = 0;
        int[] ans = new int[n - 1];
        for (int i = 1; i <= n; i++) {
            if (i != s) ans[j++] = values.getOrDefault(i, -1);
        }

        return ans;
    }


    private Map<Integer, List<Integer>> buildRoutes(int[][] graph) {
        Map<Integer, List<Integer>> routes = new HashMap<>();

        for (int[] i : graph) {
            List<Integer> l = routes.getOrDefault(i[0], new ArrayList<>());
            l.add(i[1]);
            routes.put(i[0], l);


            List<Integer> r = routes.getOrDefault(i[1], new ArrayList<>());
            r.add(i[0]);
            routes.put(i[1], r);
        }

        return routes;
    }

}
