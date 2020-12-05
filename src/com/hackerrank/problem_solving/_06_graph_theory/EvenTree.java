package com.hackerrank.problem_solving._06_graph_theory;

import java.util.*;

public class EvenTree {

    public static void main(String[] args) {
        if (true) {
            EvenTree o = new EvenTree();
            int nodes = 10, edges = 9;
            List<Integer> from = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
            List<Integer> to = Arrays.asList(1, 1, 3, 2, 1, 2, 6, 8, 8);

            System.out.println("Result = " + o.evenForest(nodes, edges, from, to)); //expected 6, 6, 12, -1
        }
    }

    private int ans = 0;

    private int evenForest(int nodes, int edges, List<Integer> from, List<Integer> to) {
        Map<Integer, List<Integer>> map = buildMap(from, to);
        boolean[] visited = new boolean[nodes + 1];

        dfs(1, visited, map);

        return ans;
    }


    private int dfs(int node, boolean[] visited, Map<Integer, List<Integer>> map) {
        if (visited[node]) return 0;
        visited[node] = true;

        int count = 0;
        for (int n : map.get(node)) {
            int children = dfs(n, visited, map);
            count += children;
        }

        if (node != 1 && (count + 1) % 2 == 0) {
            ans++;
        }

        return count + 1;
    }

    private Map<Integer, List<Integer>> buildMap(List<Integer> from, List<Integer> to) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < from.size(); i++) {
            int f = from.get(i);
            int t = to.get(i);

            List<Integer> l1 = map.getOrDefault(f, new ArrayList<>());
            List<Integer> l2 = map.getOrDefault(t, new ArrayList<>());

            l1.add(t);
            l2.add(f);

            map.put(f, l1);
            map.put(t, l2);
        }

        return map;
    }

}
