package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class Problem113 {

    public static void main(String[] args) {
        Problem113 p = new Problem113();
        TreeNode treeNode = TreeNode.initTreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        List<List<Integer>> result = p.pathSum(treeNode, 22);
        System.out.println(result.size());
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        visit(root, sum, result, stack, 0);
        return result;
    }

    public void visit(TreeNode node, int target, List<List<Integer>> result, Stack<Integer> stack, int sum) {

        sum += node.val;
        stack.add(node.val);
        if (node.left == null && node.right == null) {

            if (target == sum) {

                result.add(copy(stack));
            }
        }


        if (node.right != null) {
            visit(node.right, target, result, stack, sum);
        }
        if (node.left != null) {
            visit(node.left, target, result, stack, sum);
        }
        sum -= stack.pop();
    }

    public List<Integer> copy(Stack<Integer> list) {
        List<Integer> r = new ArrayList<>(list.size());
        r.addAll(list);
        return r;
    }

}
