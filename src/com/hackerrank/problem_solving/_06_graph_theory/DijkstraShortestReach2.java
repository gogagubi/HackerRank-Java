package com.hackerrank.problem_solving._06_graph_theory;

import java.io.*;
import java.util.*;

public class DijkstraShortestReach2 {

    public static void main(String[] args) {
        //Test Case 0
        if (true) {
            runTestCase("in/problem_solving/_06_graph_theory/DijkstraShortestReach2_TestCase0"); //expected 24 3 15
        }

        //Test Case 1
        if (false) {
            runTestCase("in/problem_solving/_06_graph_theory/DijkstraShortestReach2_TestCase1");
        }

        //Test Case 2
        if (true) {
            runTestCase("in/problem_solving/_06_graph_theory/DijkstraShortestReach2_TestCase2");
            //expected 3 6 4 5 5 4 5 4 3 3 4 6 6 4 4 4 4 5 3 4 5 3 4 6 8 4 5 3 4 4 5 4 6 6 2 4 6 4 4 4 4 5 5 3 4 5 3 6 5 4 5 5 4 4 5 3 3 4 2 3 5 2 4 4 3 4 10 5 5 7 4 4 4 1 4 4 4 5 4 4 5 4 4 5 4 5 6 5 4 4 5 5 5 4 4 4 4 3 4 5 3 3 5 4 6 8 2 5 3 4 4 5 3 5 3 3 4 5 3 6 5
        }

        //Test Case 8
        if (true) {
            runTestCase("in/problem_solving/_06_graph_theory/DijkstraShortestReach2_TestCase8"); //expected 10 16 8 -1
        }
    }

    private static void runTestCase(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            int t = Integer.valueOf(in.readLine());

            for (int i = 0; i < t; i++) {
                String[] line = in.readLine().split(" ");
                int n = Integer.valueOf(line[0]);
                int m = Integer.valueOf(line[1]);

                Map<Integer, Integer>[] nodes = new HashMap[n + 1];
                for (int j = 0; j < m; j++) {
                    line = in.readLine().split(" ");
                    int x = Integer.valueOf(line[0]);
                    int y = Integer.valueOf(line[1]);
                    int z = Integer.valueOf(line[2]);

                    if (nodes[x] == null) nodes[x] = new HashMap<>();
                    z = nodes[x].containsKey(y) ? Math.min(nodes[x].get(y), z) : z;
                    nodes[x].put(y, z);
                }

                int s = Integer.valueOf(in.readLine());

                List<int[]> edgesList = new ArrayList<>();
                for (int j = 1; j < nodes.length; j++) {
                    if (nodes[j] != null) {
                        for (int k : nodes[j].keySet()) {
                            edgesList.add(new int[]{j, k, nodes[j].get(k)});
                        }
                    }
                }

                int[][] edges = new int[edgesList.size()][3];
                for (int j = 0; j < edges.length; j++) {
                    edges[j] = edgesList.get(j);
                }

                DijkstraShortestReach2 o = new DijkstraShortestReach2();
                int[] res = o.shortestReach(n, edges, s);

                StringBuilder builder = new StringBuilder();
                for (int r : res) {
                    builder.append(r).append(" ");
                }

                System.out.println(builder.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int[] shortestReach(int n, int[][] edges, int s) {
        Map<Integer, List<int[]>> map = buildMap(edges);
        boolean[] selected = new boolean[n + 1];
        Map<Integer, Integer> values = new HashMap<>();

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{s, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (selected[curr[0]]) continue;
            selected[curr[0]] = true;

            for (int[] i : map.get(curr[0])) {
                int val = curr[1] + i[1];
                if (values.containsKey(i[0])) val = Math.min(val, values.get(i[0]));
                minHeap.add(new int[]{i[0], val});

                values.put(i[0], val);
            }
        }

        int[] ans = new int[n - 1];
        int ind = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 != s) {
                ans[ind++] = values.getOrDefault(i + 1, -1);
            }
        }

        return ans;
    }

    private Map<Integer, List<int[]>> buildMap(int[][] edges) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] i : edges) {
            List<int[]> l = map.getOrDefault(i[0], new ArrayList<>());
            l.add(new int[]{i[1], i[2]});
            map.put(i[0], l);

            List<int[]> r = map.getOrDefault(i[1], new ArrayList<>());
            r.add(new int[]{i[0], i[2]});
            map.put(i[1], r);
        }

        return map;
    }


}
