package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

public class BinarySearchTreeInsertion {

    public static void main(String[] args) {
        if (true) {
            BinarySearchTreeInsertion s = new BinarySearchTreeInsertion();
            Node root = new Node(4, 2, 7, 1, 3);

            System.out.print("Result: " + s.insert(root, 6).show());
            System.out.println();
        }

    }

    private Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else if (data > root.data) root.right = insert(root.right, data);
        else root.left = insert(root.left, data);

        return root;
    }

}
