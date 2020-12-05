package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

import java.util.Stack;

public class TreePreorderTraversal {

    public static void main(String[] args) {
        if (true) {
            TreePreorderTraversal s = new TreePreorderTraversal();
            Node root = new Node(1, null, 2, null, 5, 3, 6, null, 4);

            System.out.print("Result: ");
            s.preOrder(root);
            System.out.println();
        }

        if (true) {
            TreePreorderTraversal s = new TreePreorderTraversal();
            Node root = new Node(1, null, 2, null, 5, 3, 6, null, 4);

            System.out.print("Result: ");
            s.preOrderV1(root);
            System.out.println();
        }
    }

    private void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    private void preOrderV1(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.data + " ");

            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
    }

}
