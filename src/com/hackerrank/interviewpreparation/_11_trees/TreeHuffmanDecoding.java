package com.hackerrank.interviewpreparation._11_trees;


import com.hackerrank.model.typedTree.Node;

public class TreeHuffmanDecoding {

    public static void main(String[] args) {
        if (true) {
            TreeHuffmanDecoding o = new TreeHuffmanDecoding();
            Node<Character> root = new Node<>('5', '2', 'A', 'B', 'C');
            String s = "1001011";

            System.out.print("Result: ");
            o.decode(s, root);
            System.out.println();
        }

    }

    private void decode(String s, Node root) {
        if (root == null) return;

        Node tmp = root;
        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '0') tmp = tmp.left;
            if (c == '1') tmp = tmp.right;

            if (tmp.left == null && tmp.right == null) {
                builder.append(tmp.data);
                tmp = root;
            }
        }

        System.out.println(builder.toString());
    }

}
