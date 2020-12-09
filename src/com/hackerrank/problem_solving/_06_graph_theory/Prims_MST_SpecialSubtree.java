package com.hackerrank.problem_solving._06_graph_theory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Prims_MST_SpecialSubtree {

    public static void main(String[] args) {
        Prims_MST_SpecialSubtree o = new Prims_MST_SpecialSubtree();

        //Test Case 0
        if (true) {
            o.runTestCase("in/problem_solving/_06_graph_theory/Prims_MST_SpecialSubtree_TestCase0"); //expected 15
        }

        //Test Case 2
        if (true) {
            o.runTestCase("in/problem_solving/_06_graph_theory/Prims_MST_SpecialSubtree_TestCase2"); //expected 200
        }

        //Test Case 5
        if (true) {
            o.runTestCase("in/problem_solving/_06_graph_theory/Prims_MST_SpecialSubtree_TestCase5"); //expected 6359060
        }
    }

    private void runTestCase(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String[] line = in.readLine().split(" ");
            int n = Integer.valueOf(line[0]);
            int m = Integer.valueOf(line[1]);

            HashMap<Integer, Integer>[] nodes = new HashMap[m + 1];
            for (int i = 0; i < m; i++) {
                line = in.readLine().split(" ");
                int x = Integer.valueOf(line[0]);
                int y = Integer.valueOf(line[1]);
                int z = Integer.valueOf(line[2]);

                if (nodes[x] == null) nodes[x] = new HashMap<>();
                if (nodes[x].containsKey(y)) z = Math.min(nodes[x].get(y), z);
                nodes[x].put(y, z);
            }

            int s = Integer.valueOf(in.readLine());

            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] != null) {
                    for (int key : nodes[i].keySet()) {
                        list.add(new int[]{i, key, nodes[i].get(key)});
                    }
                }
            }

            int[][] edges = new int[list.size()][3];
            for (int i = 0; i < list.size(); i++) {
                edges[i] = list.get(i);
            }

            int ans = prims(n, edges, s);
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int prims(int n, int[][] edges, int start) {
        int ans = 0;
        Map<Integer, List<int[]>> map = buildMap(edges);
        boolean[] visited = new boolean[n + 1];


        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{start, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            if (visited[curr[0]]) continue;

            for (int[] i : map.get(curr[0])) {
                if (!(visited[i[0]])) {
                    minHeap.add(i);
                }
            }

            ans += curr[1];
            visited[curr[0]] = true;
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
