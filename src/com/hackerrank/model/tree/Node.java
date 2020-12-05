package com.hackerrank.model.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int x) {
        data = x;
    }

    public Node(int x, Node leftNode, Node rightNode) {
        data = x;

        left = leftNode;
        right = rightNode;
    }

    public Node(Object... args) {
        Integer[] arr = new Integer[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = (Integer) (args[i]);
        }

        setTree(arr);
    }

    public Node(Integer[] arr) {
        setTree(arr);
    }

    private void setTree(Integer[] arr) {
        if (arr.length == 0) {
            return;
        }

        Queue<Integer> values = new LinkedList<>();
        for (Integer i : arr) {
            values.add(i);
        }

        Queue<Node> queue = new LinkedList<>();

        this.data = values.poll();
        queue.add(this);

        while (!values.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    Integer leftValue = values.poll();
                    if (leftValue != null) {
                        node.left = new Node(leftValue);
                        queue.add(node.left);
                    }

                    Integer rightValue = values.poll();
                    if (rightValue != null) {
                        node.right = new Node(rightValue);
                        queue.add(node.right);
                    }
                }
            }
        }
    }

    public String show() {
        List<List<Integer>> list = this.levelOrder(this);

        String result = "";
        for (List<Integer> inner : list) {
            result += inner.toString() + "\n";
        }

        return result;
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                list.add(current.data);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(list);

        }

        return result;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}