package com.hackerrank.interviewpreparation._12_graphs;

import com.hackerrank.problem_solving._06_graph_theory.DijkstraShortestReach2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class FindTheNearestClone {

    public static void main(String[] args) {
        FindTheNearestClone o = new FindTheNearestClone();

        //Test Case 0
        if (false) {
            o.runTestCase("in/interviewpreparation/_12_graphs/FindTheNearestClone_TestCase0"); //1
        }

        //Test Case 1
        if (false) {
            o.runTestCase("in/interviewpreparation/_12_graphs/FindTheNearestClone_TestCase1");//-1
        }

        //Test Case 2
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/FindTheNearestClone_TestCase2"); //3
        }

        //Deleted due to big size
        //Test Case 10
        if (true) {
            //o.runTestCase("in/interviewpreparation/_12_graphs/FindTheNearestClone_TestCase10"); //-1
        }
    }


    private void runTestCase(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String[] line = in.readLine().split(" ");
            int n = Integer.valueOf(line[0]);
            int m = Integer.valueOf(line[1]);

            int[] graphFrom = new int[m];
            int[] graphTo = new int[m];

            for (int i = 0; i < m; i++) {
                line = in.readLine().split(" ");
                graphFrom[i] = Integer.valueOf(line[0]);
                graphTo[i] = Integer.valueOf(line[1]);
            }

            line = in.readLine().split(" ");
            long[] ids = new long[n];
            for (int i = 0; i < n; i++) {
                ids[i] = Long.valueOf(line[i]);
            }

            int val = Integer.valueOf(in.readLine());
            int res = findShortest(n, graphFrom, graphTo, ids, val);
            System.out.println(res);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    class Pair {
        int from;
        int steps;

        Pair(int from, int steps) {
            this.from = from;
            this.steps = steps;
        }
    }

    private int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        int ans = -1;
        Map<Integer, List<Integer>> routes = buildRoutes(graphFrom, graphTo);

        Queue<Integer> queue = new LinkedList<>();
        Pair[] visited = new Pair[graphNodes + 1];

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == val) {
                queue.add(i + 1);

                visited[i + 1] = new Pair(0, 0);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (!routes.containsKey(curr)) continue;

            for (int i : routes.get(curr)) {
                if (visited[i] == null) {
                    visited[i] = new Pair(curr, 1);
                    queue.add(i);
                } else {
                    Pair pair = visited[i];
                    if (visited[curr].from == i) continue;

                    int value = pair.steps + visited[curr].steps + 1;
                    pair.steps = value;

                    ans = ans == -1 ? value : Math.min(ans, value);
                }
            }
        }

        return ans;
    }


    private Map<Integer, List<Integer>> buildRoutes(int[] graphFrom, int[] graphTo) {
        Map<Integer, List<Integer>> routes = new HashMap<>();

        for (int i = 0; i < graphFrom.length; i++) {
            List<Integer> l = routes.getOrDefault(graphFrom[i], new ArrayList<>());
            l.add(graphTo[i]);
            routes.put(graphFrom[i], l);

            List<Integer> r = routes.getOrDefault(graphTo[i], new ArrayList<>());
            r.add(graphFrom[i]);
            routes.put(graphTo[i], r);
        }

        return routes;
    }

}
