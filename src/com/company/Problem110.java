package com.company;

public class Problem110 {

    public boolean isBalanced(TreeNode root) {
        int h = treeHeight(root);
        return h >= 0;
    }

    public int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = treeHeight(root.left);
        int r = treeHeight(root.right);
        
        if (l == -1 || r == -1) {
            return -1;
        }

        if (Math.abs(l - r) > 1) {
            return -1;
        }

        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Problem110 p = new Problem110();
        System.out.println(p.isBalanced(TreeNode.initTreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
    }
}
