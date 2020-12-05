package com.hackerrank.interviewpreparation._08_search;

import com.hackerrank.model.tree.Node;

import java.util.*;

public class SwapNodesAlgo {

    public static void main(String[] args) {
        if (true) {
            SwapNodesAlgo o = new SwapNodesAlgo();
            int[][] indexes = {
                    {2, 3},
                    {4, -1},
                    {5, -1},
                    {6, -1},
                    {7, 8},
                    {-1, 9},
                    {-1, -1},
                    {10, 11},
                    {-1, -1},
                    {-1, -1},
                    {-1, -1}
            };

            int[] queries = {2, 4};

            System.out.println("Result: ");
            int[][] result = o.swapNodes(indexes, queries);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    private int[][] swapNodes(int[][] indexes, int[] queries) {
        Node root = createTree(indexes);
        List<List<Integer>> list = new ArrayList<>();

        for (int k : queries) {
            List<Integer> row = new ArrayList<>();
            list.add(row);
            swap(root, k, 1, row);
        }

        int[][] result = new int[queries.length][indexes.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = list.get(i).get(j);
            }
        }
        return result;
    }

    private void swap(Node root, int k, int level, List<Integer> row) {
        if (root == null) return;
        if (level % k == 0) {
            Node tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }

        swap(root.left, k, level + 1, row);
        row.add(root.data);
        swap(root.right, k, level + 1, row);
    }

    private Node createTree(int[][] indexes) {
        Node root = new Node(1);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int ind = 0;
        while (!queue.isEmpty() && ind < indexes.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();

                if (indexes[ind][0] != -1) {
                    curr.left = new Node(indexes[ind][0]);
                    queue.add(curr.left);
                }

                if (indexes[ind][1] != -1) {
                    curr.right = new Node(indexes[ind][1]);
                    queue.add(curr.right);
                }

                ind++;
            }
        }

        return root;
    }

}
