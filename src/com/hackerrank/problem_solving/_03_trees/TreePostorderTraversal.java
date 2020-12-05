package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

import java.util.Stack;

public class TreePostorderTraversal {

    public static void main(String[] args) {
        if (true) {
            TreePostorderTraversal s = new TreePostorderTraversal();
            Node root = new Node(1, null, 2, null, 5, 3, 6, null, 4);

            System.out.print("Result: ");
            s.postOrder(root);
            System.out.println();
        }

        if (true) {
            TreePostorderTraversal s = new TreePostorderTraversal();
            Node root = new Node(1, null, 2, null, 5, 3, 6, null, 4);

            System.out.print("Result: ");
            s.postOrderV1(root);
            System.out.println();
        }
    }

    private void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private void postOrderV1(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(stack.size() > 0){
            Node curr = stack.peek();

            if(curr.left == null && curr.right == null){
                stack.pop();
                System.out.print(curr.data + " ");
            }
            else{
                if(curr.right != null) {
                    stack.push(curr.right);
                    curr.right = null;
                }

                if(curr.left != null) {
                    stack.push(curr.left);
                    curr.left = null;
                }
            }
        }
    }

}
