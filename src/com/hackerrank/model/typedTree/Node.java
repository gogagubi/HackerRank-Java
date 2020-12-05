package com.hackerrank.model.typedTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node<T> {
    public T data;
    public Node left;
    public Node right;

    public Node(T x) {
        data = x;
    }

    public Node(T x, Node leftNode, Node rightNode) {
        data = x;

        left = leftNode;
        right = rightNode;
    }

    public Node(Object... args) {
        T[] arr = (T[]) new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = (T) (args[i]);
        }

        setTree(arr);
    }

    /*public Node(Integer[] arr) {
        setTree(arr);
    }*/

    private void setTree(T[] arr) {
        if (arr.length == 0) {
            return;
        }

        Queue<T> values = new LinkedList<>();
        for (T i : arr) {
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
                    T leftValue = values.poll();
                    if (leftValue != null) {
                        node.left = new Node(leftValue);
                        queue.add(node.left);
                    }

                    T rightValue = values.poll();
                    if (rightValue != null) {
                        node.right = new Node(rightValue);
                        queue.add(node.right);
                    }
                }
            }
        }
    }

    public String show() {
        List<List<T>> list = this.levelOrder(this);

        String result = "";
        for (List<T> inner : list) {
            result += inner.toString() + "\n";
        }

        return result;
    }

    public List<List<T>> levelOrder(Node root) {
        List<List<T>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<T> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                list.add((T) current.data);

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