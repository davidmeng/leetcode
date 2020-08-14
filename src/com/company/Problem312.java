package com.company;

import java.util.Map;

public class Problem312 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Problem312 p = new Problem312();
        System.out.println(p.maxCoins(new int[]{3,1,5,8}));

        System.out.println("total cost: " + (System.currentTimeMillis() - start));
    }

    public int maxCoins(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int [][] dp = new int[nums.length + 2][nums.length + 2];
        for (int i = 0 ; i<dp.length ; i++) {
            for (int j = 0 ; j<dp[0].length ; j++) {
                dp[i][j] = -1;
            }
        }
        return  maxCoins(nums, -1, nums.length , dp);
    }

    public int maxCoins(int [] nums, int start, int end , int[][] dp) {
        if (dp[start+1][end+1] != -1) {
            return dp[start+1][end+1];
        }

        if (start == nums.length) {
            dp[start+1][end+1] = 0;
            return 0;
        }

        if (end == 0) {
            dp[start+1][end+1] = 0;
            return 0;
        }

        if (start == end - 2) {
            dp[start+1][end+1] = nums[start+1];
            return nums[start+1];
        }

        int max = 1;
        for (int i = start; i<end ; i++) {
            for (int j = i + 1 ; j<end; j++) {
                for (int k = j+1; k<end ; k++) {

                }
            }
        }

        dp[start+1][end+1] = max;
        return max;
    }
}
