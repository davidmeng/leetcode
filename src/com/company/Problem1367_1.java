package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem1367_1 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        Map<TreeNode, TreeNode> map = init(root, new HashMap<TreeNode, TreeNode>());
        List<Integer> list = init(head);

        return process(map, list, list.size() - 1, root);
    }

    public boolean process(Map<TreeNode, TreeNode> map, List<Integer> list, int index, TreeNode node) {
        if (this.find(map, list, index, node)) {
            return true;
        }

        if (node.left != null) {
            return process(map, list, index, node.left);
        }

        if (node.right != null) {
            return process(map, list, index, node.right);
        }

        return false;
    }

    public boolean find(Map<TreeNode, TreeNode> map, List<Integer> list, int index, TreeNode node) {

        if (node == null) {
            return false;
        }

        if (index == 0 && list.get(0) == node.val) {
            return true;
        }

        if (node.val == list.get(index)) {
            return find(map, list, --index, map.get(node));
        } else {
            return false;
        }
    }

    public Map<TreeNode, TreeNode> init(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root.left != null) {
            map.put(root.left, root);
            init(root.left, map);
        }

        if (root.right != null) {
            map.put(root.right, root);
            init(root.right, map);
        }

        return map;
    }

    public List<Integer> init(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return list;
    }

    public static void main(String [] args) {

        TreeNode treeNode = init(new Integer[] {1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3});
        ListNode list = initListNode(new Integer[] {1,4,2,6});

        Problem1367_1 p = new Problem1367_1();

        System.out.print(p.isSubPath(list, treeNode));
    }

    public static TreeNode init(Integer[] arr) {

        TreeNode head = new TreeNode(arr[0]);
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(head);

        for (int i = 1; i < arr.length; i+=2) {
            TreeNode temp = list.pollFirst();
            if (arr[i]!=null) {
                TreeNode left = new TreeNode(arr[i]);
                list.add(left);
                temp.left = left;
            }

            if (arr[i+1]!=null) {
                TreeNode right = new TreeNode(arr[i+1]);
                list.add(right);
                temp.right = right;
            }
        }
        return head;
    }

    public static ListNode initListNode(Integer[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode node = head;
        for (int i = 1 ; i<arr.length ;i++){
            ListNode temp = new ListNode(arr[i]);
            node.next = temp;
            node = temp;
        }

        return head;
    }

}
