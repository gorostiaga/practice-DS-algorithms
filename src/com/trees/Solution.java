package com.trees;

public class Solution {
    static int max = 0;

    public static void main(String[] args) {
        Node root;
        root = new Node(1);
        root.left = new Node(1);
        root.left.left = new Node(2);
        root.left.left.left = new Node(2);
        root.left.left.left.left = new Node(2);
        root.left.left.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(3);
        root.left.right.left.right = new Node(4);
        root.right = new Node(4);

        System.out.println(diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(Node root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(Node root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
