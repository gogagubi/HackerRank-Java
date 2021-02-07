package com.hackerrank.interviewpreparation._12_graphs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Matrix {

    public static void main(String[] args) {
        Matrix o = new Matrix();

        //Test Case 0
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/Matrix_TestCase0");
        }

        //Test Case 2
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/Matrix_TestCase2"); //610
        }

        //Test Case 10
        if (true) {
            o.runTestCase("in/interviewpreparation/_12_graphs/Matrix_TestCase10");
        }
    }


    private void runTestCase(String fileName) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            String[] line = in.readLine().split(" ");
            int n = Integer.valueOf(line[0]);
            int k = Integer.valueOf(line[1]);

            int[][] roads = new int[n - 1][3];
            for (int i = 0; i < n - 1; i++) {
                String[] l = in.readLine().split(" ");

                roads[i] = new int[]{
                        Integer.valueOf(l[0]),
                        Integer.valueOf(l[1]),
                        Integer.valueOf(l[2]),
                };
            }

            int[] machines = new int[k];
            for (int i = 0; i < k; i++) {
                machines[i] = Integer.valueOf(in.readLine());
            }

            int ans = minTime(roads, machines);
            System.out.println(ans);

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class DisjoinSet {
        int[] arr;
        int[] ranks;
        boolean[] machines;

        public DisjoinSet(int n) {
            n += 1;
            arr = new int[n];
            ranks = new int[n];
            machines = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                ranks[i] = 1;
            }
        }

        void addMachine(Integer machine) {
            machines[machine] = true;
        }

        int find(int x) {
            if (arr[x] == x) return x;
            return find(arr[x]);
        }

        void union(int u, int v) {
            if (ranks[u] >= ranks[v]) {
                arr[v] = u;
                ranks[u] += ranks[v];

                if (machines[v]) machines[u] = true;
            } else {
                arr[u] = v;
                ranks[v] += ranks[u];

                if (machines[u]) machines[v] = true;
            }
        }

        boolean hasMachine(int x) {
            return machines[x];
        }
    }

    private int minTime(int[][] roads, int[] machines) {
        int ans = 0;

        DisjoinSet ds = new DisjoinSet(roads.length + 1);
        Arrays.sort(roads, (a, b) -> Integer.compare(b[2], a[2]));

        for (int i : machines) ds.addMachine(i);

        for (int[] i : roads) {
            int u = ds.find(i[0]);
            int v = ds.find(i[1]);

            if (u != v) {
                if (ds.hasMachine(u) && ds.hasMachine(v)) {
                    ans += i[2];
                } else {
                    ds.union(u, v);
                }
            }
        }

        return ans;
    }

}
