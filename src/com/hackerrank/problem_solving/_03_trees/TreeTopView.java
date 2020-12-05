package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

import java.util.*;

public class TreeTopView {

    public static void main(String[] args) {
        if (true) {
            TreeTopView s = new TreeTopView();
            Node root = new Node(1, null, 2, null, 5, 3, 6, null, 4);

            System.out.print("Result: ");
            s.topView(root);
            System.out.println();
        }

        if (true) {
            TreeTopView s = new TreeTopView();
            Node root = new Node(1, 2, 3, 4, 5, 6, 7);

            System.out.print("Result: ");
            s.topView(root);
            System.out.println();
        }

    }

    public class Pair {
        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }

        public Node node;
        public int level;
    }

    private void topView(Node root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        Map<Integer, Node> map = new TreeMap<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair currPair = queue.poll();
                Node currNode = currPair.node;
                int currLevel = currPair.level;

                if (!map.containsKey(currLevel)) {
                    map.put(currLevel, currNode);
                }

                if (currNode.left != null)
                    queue.add(new Pair(currNode.left, currLevel - 1));
                if (currNode.right != null)
                    queue.add(new Pair(currNode.right, currLevel + 1));

            }
        }

        for (int key : map.keySet()) {
            System.out.print(map.get(key).data + " ");
        }
    }


}
