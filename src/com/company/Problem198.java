package com.company;

public class Problem198 {

    public static void main(String[] args) {
        Problem198 p = new Problem198();
        System.out.println(p.rob(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] arr = new int[nums.length];
        int[] arr1 = new int[nums.length];
        return Math.max(dp(nums, 1, arr), nums[0] + dp(nums, 2, arr));
    }


    public int dp(int[] nums, int i, int[] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i] != 0) {
            return dp[i];
        } else if (nums[i] == 0) {
            return dp(nums, i + 1, dp);
        } else if (i == nums.length - 1) {
            dp[i] = nums[i];
            return nums[i];
        } else {
            int value = Math.max(nums[i] + dp(nums, i + 2, dp), dp(nums, i + 1, dp));
            dp[i] = value;
            return dp[i];
        }
    }

}
