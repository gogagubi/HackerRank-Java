package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

import java.util.Stack;

public class TreeHeightOfBinaryTree {

    public static void main(String[] args) {
        if (true) {
            TreeHeightOfBinaryTree s = new TreeHeightOfBinaryTree();
            Node root = new Node(1, null, 2, null, 5, 3, 6, null, 4);

            System.out.print("Result: " + s.height(root));
            System.out.println();
        }

        if (true) {
            TreeHeightOfBinaryTree s = new TreeHeightOfBinaryTree();
            Node root = new Node(3, 2, 5, 1, null, 4, 6, null, null, 7);

            System.out.print("Result: " + s.height(root));
            System.out.println();
        }
    }

    private int height(Node root) {
        return calcHeight(root, 0);
    }

    private int calcHeight(Node root, int level) {
        if (root == null) return 0;

        int max = Math.max(calcHeight(root.left, level + 1), calcHeight(root.right, level + 1));
        max = Math.max(max, level);
        return max;
    }

}
