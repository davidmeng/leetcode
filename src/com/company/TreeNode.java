package com.company;

import java.util.LinkedList;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode initTreeNode(Integer[] arr) {

        TreeNode head = new TreeNode(arr[0]);
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(head);

        for (int i = 1; i < arr.length; i += 2) {
            TreeNode temp = list.pollFirst();
            if (arr[i] != null) {
                TreeNode left = new TreeNode(arr[i]);
                list.add(left);
                temp.left = left;
            }

            if (i+1 < arr.length && arr[i + 1] != null) {
                TreeNode right = new TreeNode(arr[i + 1]);
                list.add(right);
                temp.right = right;
            }
        }
        return head;
    }
}
