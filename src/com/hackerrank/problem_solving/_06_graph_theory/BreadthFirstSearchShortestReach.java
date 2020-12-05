package com.hackerrank.problem_solving._06_graph_theory;

import java.util.*;

public class BreadthFirstSearchShortestReach {

    public static void main(String[] args) {
        if (false) {
            BreadthFirstSearchShortestReach o = new BreadthFirstSearchShortestReach();
            int n = 5, m = 3;
            int[][] edges = {{1, 2}, {1, 3}, {3, 4}};
            int s = 1;

            System.out.println("Result = " + Arrays.toString(o.bfs(n, m, edges, s))); //expected 6, 6, 12, -1
        }

        if (false) {
            BreadthFirstSearchShortestReach o = new BreadthFirstSearchShortestReach();
            int n = 3, m = 1;
            int[][] edges = {{2, 3}};
            int s = 2;

            System.out.println("Result = " + Arrays.toString(o.bfs(n, m, edges, s))); //expected -1, 6
        }

        if (true) {
            BreadthFirstSearchShortestReach o = new BreadthFirstSearchShortestReach();
            int n = 10, m = 6;
            int[][] edges = {
                    {3, 1},
                    {10, 1},
                    {10, 1},
                    {3, 1},
                    {1, 8},
                    {5, 2},
            };
            int s = 3;

            System.out.println("Result = " + Arrays.toString(o.bfs(n, m, edges, s))); //expected 6 -1 -1 -1 -1 -1 12 -1 12
        }

    }

    private int[] bfs(int n, int m, int[][] edges, int s) {
        Map<Integer, Integer> buffer = new HashMap<>();
        Map<Integer, List<Integer>> map = buildMap(edges);
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;
        buffer.put(s, 0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (map.containsKey(node)) {
                for (int neighbor : map.get(node)) {
                    if (!visited[neighbor]) {
                        buffer.put(neighbor, buffer.get(node) + 6);

                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }

        int ind = 0;
        int[] result = new int[n - 1];
        for (int i = 1; i <= n; i++) {
            if (buffer.containsKey(i)) {
                if (buffer.get(i) != 0) {
                    result[ind++] = buffer.get(i);
                }
            } else result[ind++] = -1;
        }

        return result;
    }

    private Map<Integer, List<Integer>> buildMap(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            List<Integer> s = map.getOrDefault(e[0], new ArrayList<>());
            s.add(e[1]);
            map.put(e[0], s);

            List<Integer> d = map.getOrDefault(e[1], new ArrayList<>());
            d.add(e[0]);
            map.put(e[1], d);
        }

        return map;
    }

}
