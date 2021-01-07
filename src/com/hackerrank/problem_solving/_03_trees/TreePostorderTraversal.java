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
            Node root = new Node(1, 2, 3, 4, 5, 6, 7);

            System.out.print("Result: ");
            s.postOrder(root);
            System.out.println();
        }
    }


    private void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node prev = root;
        while (stack.size() > 0) {
            Node curr = stack.peek();

            if ((curr.left == null && curr.right == null) || prev == curr.left || prev == curr.right) {
                stack.pop();
                System.out.print(curr.data + " ");
                prev = curr;
            } else {
                if (curr.right != null) stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }
    }

}
