package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Problem213 {

    public static void main(String[] args) {
        Problem213 p = new Problem213();
        System.out.println(p.rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] arr = new int[nums.length];
        int[] arr1 = new int[nums.length];
        return Math.max(dp(nums, 1, arr, arr1, false), nums[0] + dp(nums, 2, arr, arr1, true));
    }


    public int dp(int[] nums, int i, int[] dp, int[] dp1, boolean chooseFirst) {
        if (i >= nums.length) {
            return 0;
        }
        if (nums[i] == 0) {
            return dp(nums, i + 1, dp, dp1, chooseFirst);
        }
        int cache = this.getValue(dp, dp1, chooseFirst, i);
        if (cache != 0) {
            return cache;
        } else if (i == nums.length - 1) {
            int value = 0;
            if (!chooseFirst) {
                value = nums[i];
            }

            save(dp, dp1, chooseFirst, i, value);
            return value;
        } else {
            int value = Math.max(nums[i] + dp(nums, i + 2, dp, dp1, chooseFirst), dp(nums, i + 1, dp, dp1, chooseFirst));
            save(dp, dp1, chooseFirst, i, value);
            return value;
        }
    }

    public int save(int[] dp, int[] dp1, boolean chooseFirst, int i, int value) {
        if (chooseFirst) {
            dp[i] = value;
        } else {
            dp1[i] = value;
        }

        return value;
    }

    public int getValue(int[] dp, int[] dp1, boolean chooseFirst, int i) {
        if (chooseFirst) {
            return dp[i];
        }

        return dp1[i];
    }
}
