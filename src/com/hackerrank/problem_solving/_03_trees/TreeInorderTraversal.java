package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

import java.util.Stack;

public class TreeInorderTraversal {

    public static void main(String[] args) {
        if (true) {
            TreeInorderTraversal s = new TreeInorderTraversal();
            Node root = new Node(1, null, 2, null, 5, 3, 6, null, 4);

            System.out.print("Result: ");
            s.inOrder(root);
            System.out.println();
        }

        if (true) {
            TreeInorderTraversal s = new TreeInorderTraversal();
            Node root = new Node(1, 2, 3, 4, 5, 6, 7);

            System.out.print("Result: ");
            s.inOrderV1(root);
            System.out.println();
        }
    }

    private void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private void inOrderV1(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || stack.size() > 0) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

}
