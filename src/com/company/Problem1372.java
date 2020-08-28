package com.company;


public class Problem1372 {
    public static void main(String[] args) {
        TreeNode t = TreeNode.initTreeNode(new Integer[] {1,1,1,null,1,null,null,1,1,null,1});
        Problem1372 p = new Problem1372();
        System.out.println(p.longestZigZag(t));
    }

    private class Result{
        int val = 0 ;
    }

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Result r1 = new Result();
        Result r2 = new Result();

        if (root.left != null) {
            maxSize(root.left , true, 1, r1);
        }

        if (root.right != null) {
            maxSize(root.right , false, 1, r2);
        }

        return Math.max(r1.val, r2.val);
    }

    public void maxSize(TreeNode node, boolean left, int size , Result result) {
        result.val = Math.max(size, result.val);
        if (left) {
            if (node.right != null) {

                maxSize(node.right, false, size + 1, result);
            }

            if (node.left != null) {

                maxSize(node.left, true, 1, result);
            }
        } else {
            if (node.right != null) {

                maxSize(node.right, false, 1, result);
            }

            if (node.left != null) {

                maxSize(node.left, true, size + 1, result);
            }
        }
    }
}

