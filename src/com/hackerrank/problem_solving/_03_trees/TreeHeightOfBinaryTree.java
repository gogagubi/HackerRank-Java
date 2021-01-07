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
        if (root == null) return -1;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

}
