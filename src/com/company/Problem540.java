package com.company;

public class Problem540 {

    public int singleNonDuplicate(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        int mid = (end - start) / 2;
        if (mid == 0 && nums[mid] != nums[mid + 1]) {
            return nums[mid];
        }

        if (mid == (nums.length - 1) && nums[mid] != nums[mid - 1]) {
            return nums[mid];
        }

        if (nums[mid] == nums[mid - 1] || nums[mid] == nums[mid + 1]) {

            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    return find(nums, start, mid - 1);
                } else {
                    return find(nums, mid + 1, end);
                }
            } else {
                if (mid % 2 == 0) {
                    return find(nums, start, mid - 1);
                } else {
                    return find(nums, mid + 1, end);
                }
            }
        }

        return nums[mid];
    }
}
