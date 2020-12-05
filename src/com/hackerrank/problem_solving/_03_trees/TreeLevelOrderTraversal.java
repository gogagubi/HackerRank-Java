package com.hackerrank.problem_solving._03_trees;

import com.hackerrank.model.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderTraversal {

    public static void main(String[] args) {
        if (true) {
            TreeLevelOrderTraversal s = new TreeLevelOrderTraversal();
            Node root = new Node(1, null, 2, null, 5, 3, 6, null, 4);

            System.out.print("Result: ");
            s.levelOrder(root);
            System.out.println();
        }
    }

    private void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
    }

}
