package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

public class IsThisBinarySearchTree {

    public static void main(String[] args) {
        if (true) {
            IsThisBinarySearchTree s = new IsThisBinarySearchTree();
            Node root = new Node(3, 5, 2, 1, 4, 6);

            System.out.println("Result: " + s.checkBST(root));
        }

        if (true) {
            IsThisBinarySearchTree s = new IsThisBinarySearchTree();
            Node root = new Node(4, 2, 6, 1, 3, 5, 7);

            System.out.println("Result: " + s.checkBST(root));
        }

        if (true) {
            IsThisBinarySearchTree s = new IsThisBinarySearchTree();
            Node root = new Node(7, 5, 9, 3, 6, 8, 12);

            System.out.println("Result: " + s.checkBST(root));
        }

        if (true) {
            IsThisBinarySearchTree s = new IsThisBinarySearchTree();
            Node root = new Node(3, 2, 6, 1, 4, 5, 7);

            System.out.println("Result: " + s.checkBST(root));
        }
    }

    private boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node root, int min, int max){
        if(root == null) return true;

        if(root.data < min || root.data > max) return false;
        return checkBST(root.left, min, root.data - 1)
                && checkBST(root.right, root.data + 1, max);
    }

}
