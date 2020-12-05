package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

public class BinarySearchTreeLowestCommonAncestor {

    public static void main(String[] args) {
        if (true) {
            BinarySearchTreeLowestCommonAncestor s = new BinarySearchTreeLowestCommonAncestor();
            Node root = new Node(4, 2, 7, 1, 3, 5);
            int v1 = 1, v2 = 7;

            System.out.println("Result: " + s.lca(root, v1, v2).data);
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
