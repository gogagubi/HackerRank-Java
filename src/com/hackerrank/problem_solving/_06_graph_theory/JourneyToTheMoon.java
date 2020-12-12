package com.hackerrank.problem_solving._06_graph_theory;

import java.util.*;

public class JourneyToTheMoon {

    public static void main(String[] args) {
        if (true) {
            JourneyToTheMoon o = new JourneyToTheMoon();
            int n = 5;
            int[][] astronaut = {
                    {0, 1},
                    {2, 3},
                    {0, 4}
            };

            System.out.println("Result = " + o.journeyToMoon(n, astronaut)); //expected 6
            System.out.println("Result = " + o.journeyToMoonV1(n, astronaut)); //expected 6
        }

        if (true) {
            JourneyToTheMoon o = new JourneyToTheMoon();
            int n = 9;
            int[][] astronaut = {
                    {0, 1},
                    {0, 2},
                    {4, 5},
                    {7, 8}
            };

            System.out.println("Result = " + o.journeyToMoon(n, astronaut)); //expected 31
            System.out.println("Result = " + o.journeyToMoonV1(n, astronaut)); //expected 31
        }

        if (true) {
            JourneyToTheMoon o = new JourneyToTheMoon();
            int n = 100000;
            int[][] astronaut = {
                    {1, 2},
                    {3, 4}
            };

            System.out.println("Result = " + o.journeyToMoon(n, astronaut)); //expected 4999949998
            System.out.println("Result = " + o.journeyToMoonV1(n, astronaut)); //expected 4999949998
        }
    }

    private long journeyToMoon(int n, int[][] astronaut) {
        Map<Integer, List<Integer>> map = buildMap(astronaut);
        boolean[] visited = new boolean[n];

        long ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, visited, map);
            if (count > 0) {
                ans += sum * count;
                sum += count;
            }
        }

        return ans;
    }

    private long journeyToMoonV1(int n, int[][] astronaut) {
        Map<Integer, List<Integer>> map = buildMap(astronaut);
        boolean[] visited = new boolean[n];

        long ans = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; i++) {
            int count = dfs(i, visited, map);
            if (count > 0) {
                ans -= (count * (count - 1)) / 2;
            }
        }

        return ans;
    }

    public int dfs(int i, boolean[] visited, Map<Integer, List<Integer>> map) {
        int count = 0;

        if (visited[i]) return count;
        visited[i] = true;

        if (map.containsKey(i)) {
            for (int node : map.get(i)) {
                count += dfs(node, visited, map);
            }
        }

        return count + 1;
    }

    private Map<Integer, List<Integer>> buildMap(int[][] astronaut) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] i : astronaut) {
            List<Integer> l = map.getOrDefault(i[0], new ArrayList<>());
            l.add(i[1]);
            map.put(i[0], l);

            List<Integer> r = map.getOrDefault(i[1], new ArrayList<>());
            r.add(i[0]);
            map.put(i[1], r);
        }

        return map;
    }

}
