package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Problem109 {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            list.add(t.val);
            t = t.next;
        }

        return initTree(0, list.size(), list);
    }

    public TreeNode initTree(int start, int end, List<Integer> list) {

        if (start == end) {
            if (start >= list.size()) {
                return null;
            }
            return new TreeNode(list.get(start));
        }

        if (start > end) {
            return null;
        }

        int middle = (start + end) / 2;
        TreeNode t = new TreeNode(list.get(middle));

        t.left = initTree(start, middle - 1, list);
        t.right = initTree(middle + 1, end, list);


        return t;
    }

    public static void main(String[] args) {
        Problem109 p = new Problem109();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;


        TreeNode t = p.sortedListToBST(l1);
        System.out.println(t.val);
    }

}
