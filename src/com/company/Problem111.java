package com.company;

public class Problem111 {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }

        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }

        int length = Math.min(minDepth(root.left), minDepth(root.right)) + 1;

        return length;
    }
}
