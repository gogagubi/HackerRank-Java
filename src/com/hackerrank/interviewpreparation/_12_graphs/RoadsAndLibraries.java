package com.hackerrank.interviewpreparation._12_graphs;

import java.util.*;

public class RoadsAndLibraries {

    public static void main(String[] args) {
        if (true) {
            RoadsAndLibraries o = new RoadsAndLibraries();
            int n = 8;
            int c_lib = 3;
            int c_road = 2;
            int[][] cities = {
                    {1, 2},
                    {1, 4},
                    {2, 3},
                    {2, 5},
                    {4, 5},
                    {6, 7},
                    {7, 8}
            };

            System.out.println("Result = " + o.roadsAndLibraries(n, c_lib, c_road, cities));
        }


        if (true) {
            RoadsAndLibraries o = new RoadsAndLibraries();
            int n = 3;
            int c_lib = 2;
            int c_road = 1;
            int[][] cities = {
                    {1, 2},
                    {3, 1},
                    {2, 3}
            };

            System.out.println("Result = " + o.roadsAndLibraries(n, c_lib, c_road, cities));
        }

        if (true) {
            RoadsAndLibraries o = new RoadsAndLibraries();
            int n = 6;
            int c_lib = 2;
            int c_road = 5;
            int[][] cities = {
                    {1, 3},
                    {3, 4},
                    {2, 4},
                    {1, 2},
                    {2, 3},
                    {5, 6},
            };

            System.out.println("Result = " + o.roadsAndLibraries(n, c_lib, c_road, cities));
        }
    }

    private long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        Map<Integer, List<Integer>> routes = this.buildRoutes(cities);
        boolean[] visited = new boolean[n + 1];
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                counts.put(i, dfs(i, visited, routes) + 1);
            }
        }

        long ans = 0;
        for (int key : counts.keySet()) {
            int curr = counts.get(key);

            long moreRoads = ((long) c_road * (curr - 1)) + c_lib;
            long moreLibraries = c_lib * (long) curr;
            ans += Math.min(moreRoads, moreLibraries);
        }

        return ans;
    }

    private int dfs(int i, boolean[] visited, Map<Integer, List<Integer>> routes) {
        int count = 0;
        if (!routes.containsKey(i)) return count;

        for (int j : routes.get(i)) {
            if (!visited[j]) {
                visited[j] = true;
                count += (dfs(j, visited, routes) + 1);
            }
        }

        return count;
    }

    private Map<Integer, List<Integer>> buildRoutes(int[][] cities) {
        Map<Integer, List<Integer>> routes = new HashMap<>();

        for (int[] i : cities) {
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
