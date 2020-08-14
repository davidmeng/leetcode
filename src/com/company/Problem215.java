package com.company;

import java.util.LinkedList;
import java.util.List;

public class Problem215 {

    public static void main(String[] args) {
        Problem215 p = new Problem215();
        System.out.println(p.findKthLargest(new int[]{-1, -1}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }

        return find(list, k);
    }

    public int find(LinkedList<Integer> nums, int k) {
        if (nums.size() == 1) {
            return nums.get(0);
        }
        int t = nums.remove(nums.size() / 2);
        LinkedList<Integer> bigger = new LinkedList<>();
        LinkedList<Integer> smaller = new LinkedList<>();
        LinkedList<Integer> equal = new LinkedList<>();
        while (!nums.isEmpty()) {
            int v = nums.remove(0);
            if (v > t) {
                bigger.add(v);
            } else if (v < t) {
                smaller.add(v);
            } else {
                equal.add(v);
            }
        }

        if (k == bigger.size() + 1) {
            return t;
        } else if (k > bigger.size() && k <= (bigger.size() + equal.size() + 1)) {
            return t;
        } else if (k <= bigger.size()) {
            return find(bigger, k);
        } else {
            return find(smaller, k - bigger.size() - equal.size() - 1);
        }
    }
}
