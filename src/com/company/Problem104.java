package com.company;

public class Problem104 {

    public static void main(String[] args) {


    }

    public int maxDepth(TreeNode root) {

        return maxDepth(root, 0, 0);
    }

    public int maxDepth(TreeNode root, int level,  int maxLevel) {
        if (root == null) {
            maxLevel = Math.max(level, maxLevel);
        }

        return Math.max(maxDepth(root.left, level + 1,maxLevel), maxDepth(root.right, level + 1,maxLevel)) ;
    }
}
