package com.hackerrank.interviewpreparation._12_graphs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class FindTheNearestCloneV1 {

    public static void main(String[] args) {
        FindTheNearestCloneV1 o = new FindTheNearestCloneV1();

        //Test Case 0
        if (false) {
            o.runTestCase("in/interviewpreparation/_12_graphs/FindTheNearestClone_TestCase0"); //1
        }

        //Test Case 1
        if (false) {
            o.runTestCase("in/interviewpreparation/_12_graphs/FindTheNearestClone_TestCase1");//-1
        }

        //Test Case 2
        if (false) {
            o.runTestCase("in/interviewpreparation/_12_graphs/FindTheNearestClone_TestCase2"); //3
        }

        //Test Case 10
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/FindTheNearestClone_TestCase10"); //-1
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

    private int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        int ans = -1;
        Map<Integer, List<Integer>> routes = buildRoutes(graphFrom, graphTo);

        Map<Integer, Long> colors = new HashMap<>();

        int source = 0;
        int clones = 0;

        for (int i = 0; i < ids.length; i++) {
            colors.put(i + 1, ids[i]);
            clones++;

            if (ids[i] == val && source == 0) source = i + 1;
        }

        if (source == 0 || clones < 2) return ans;

        Map<Integer, Integer> values = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graphNodes + 1];

        queue.add(source);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr]) continue;

            visited[curr] = true;
            if (!routes.containsKey(curr)) continue;

            for (int i : routes.get(curr)) {
                if (visited[i]) continue;

                int destValue = values.getOrDefault(curr, 0) + 1;
                if (values.containsKey(i)) destValue = Math.min(values.get(i), destValue);
                values.put(i, destValue);

                queue.add(i);
                if (colors.get(i) == val) ans = ans == -1 ? destValue : Math.min(ans, destValue);
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
