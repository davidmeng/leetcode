package com.company;

import java.util.LinkedList;

public class Problem215_1 {

    public static void main(String[] args) {
        Problem215_1 p = new Problem215_1();
        System.out.println(p.findKthLargest(new int[]{-1, -1}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }

        //return find(list, k);
        return 1;
    }

    public int find(int start, int end, int[] nums, int k) {

        /*if (start == end) {
            return nums[start];
        }
        int q = start + (end - start) * Math.random();

        int [] flags = resort(nums, q);
        if (k >= flags [0] && k<= flags[1]) {
            return flags[k];
        }*/

        //if (k )]
        return 1;
    }

    public int[] resort(int[] nums, int f) {
        return null;
    }
}
