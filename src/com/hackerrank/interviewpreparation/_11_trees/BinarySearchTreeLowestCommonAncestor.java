package com.hackerrank.interviewpreparation._11_trees;

import com.hackerrank.model.tree.Node;

public class BinarySearchTreeLowestCommonAncestor {

    public static void main(String[] args) {
        if (true) {
            BinarySearchTreeLowestCommonAncestor s = new BinarySearchTreeLowestCommonAncestor();
            Node root = new Node(4, 2, 7, 1, 3, 5);
            int v1 = 1, v2 = 7;

            System.out.println("Result: " + s.lca(root, v1, v2).data); //expected 4
        }

        if (true) {
            BinarySearchTreeLowestCommonAncestor s = new BinarySearchTreeLowestCommonAncestor();
            Node root = new Node(10, 8, 12, 5, 9, 11, 16, null, null, null, null, null, null, 14, 18, 13, 15);
            int v1 = 13, v2 = 18;

            System.out.println("Result: " + s.lca(root, v1, v2).data); //expected 12
        }

        if (true) {
            BinarySearchTreeLowestCommonAncestor s = new BinarySearchTreeLowestCommonAncestor();
            Node root = new Node(50, 30, 51, 15, 32, null, null, 10, null, 31, 35, null, null, null, null, 34, 37, 33, 35);
            int v1 = 33, v2 = 37;

            System.out.println("Result: " + s.lca(root, v1, v2).data); //expected 12
        }
    }

    private Node lca(Node root, int v1, int v2) {
        if (root.data > Math.max(v1, v2))
            return lca(root.left, v1, v2);
        else if (root.data < Math.min(v1, v2))
            return lca(root.right, v1, v2);
        else
            return root;
    }

}
