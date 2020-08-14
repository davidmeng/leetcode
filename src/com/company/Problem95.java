package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem95 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Problem95 p = new Problem95();
        List<TreeNode> lists = p.generateTrees(3);
        for (TreeNode node : lists) {
            System.out.println(node.val);
        }

    }

    public List<TreeNode> generateTrees(int n) {

        return generate(1, n);
    }

    public List<TreeNode> generate(int from, int to) {
        List<TreeNode> lists = new LinkedList<>();
        if (from > to) {
            lists.add(null);
            return lists;
        }

        if (from == to) {
            lists.add(new TreeNode(from));
            return lists;
        }

        for (int i = from; i <= to; i++) {
            TreeNode head = new TreeNode(i);
            List<TreeNode> left = generate(from, i - 1);
            List<TreeNode> right = generate(i + 1, to);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    head.left = l;
                    head.right = r;
                    lists.add(head);
                }
            }
        }

        return lists;
    }
}
