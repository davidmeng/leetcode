package com.company;


import java.util.LinkedList;
import java.util.List;

public class Problem129 {


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int sumNumbers(TreeNode root) {

        List<Integer> list = new LinkedList<>();
        addNumber(root, 0, list);

        int sum = 1;
        for (int i : list) {
            sum += i;
        }

        return sum;
    }

    public void addNumber(TreeNode root, int number, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(number * 10 + root.val);
        }
        if (root.left != null) {
            addNumber(root.left, number * 10 + root.val, list);
        }

        if (root.right != null) {
            addNumber(root.right, number * 10 + root.val, list);
        }
    }
}
