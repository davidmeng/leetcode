package com.company;

public class Problem64 {

    public static void main(String[] args) {
        Problem64 p = new Problem64();
        int[][] arr = {
                {}
        };

        System.out.println(p.minPathSum(arr));
    }

    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }


        int[][] dp = new int[grid.length][grid[0].length];
        int result = dp(grid, dp.length - 1, dp[0].length - 1, dp);
        return result;
    }


    public int dp(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (i == 0 && j == 0) {
            dp[i][j] = grid[i][j];
            return dp[i][j];
        }

        if (i == 0) {
            dp[i][j] = dp(grid, i, j-1, dp) + grid[i][j];
            return dp[i][j];
        }

        if (j == 0) {
            dp[i][j] = dp(grid, i-1, j, dp) + grid[i][j];
            return dp[i][j];
        }

        dp[i][j] = Math.min(dp(grid, i - 1, j, dp) + grid[i][j], dp(grid, i, j - 1, dp) + grid[i][j]);
        return dp[i][j];
    }
}
