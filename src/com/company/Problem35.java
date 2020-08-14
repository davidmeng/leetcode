package com.company;

public class Problem35 {

    public static void main(String[] args) {
        Problem35 p = new Problem35();
        System.out.println(p.searchInsert(new int []{1,3,5,6}, 5));
        System.out.println(p.searchInsert(new int []{1,3,5,6}, 2));
        System.out.println(p.searchInsert(new int []{1,3,5,6}, 7));
        System.out.println(p.searchInsert(new int []{1,3,5,6}, 0));

    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    public int searchInsert(int[] nums, int target, int start, int end) {

        if (start == end) {
            if (target <= nums[start]) {
                return start;
            } return start + 1;
        }

        int min = start + (end - start) / 2;
        if (nums[min] == target) {
            return min;
        }

        if (target < nums[min]) {
            return searchInsert(nums, target, start, min);
        }

        return  searchInsert(nums, target, min + 1, end);
    }

}
