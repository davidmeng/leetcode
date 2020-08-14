package com.company;

public class Problem958 {

    private static boolean noChild = false;

    public boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }
        noChild = false;
        return visit(root);
    }

    public boolean visit(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (noChild) {
            if (root.right != null || root.right != null) {
                return false;
            }
        }


        if (root.right != null && root.left == null) {
            return false;
        }

        if (root.right == null) {
            noChild = true;
        }

        return visit(root.left) && visit(root.right);
    }

    public static void main(String[] args) {
        TreeNode t = TreeNode.initTreeNode(new Integer[]{1,2,3,5,6,7,8});
        Problem958 p = new Problem958();
        System.out.println(p.isCompleteTree(t));
    }
}
