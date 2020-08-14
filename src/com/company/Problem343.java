package com.company;

public class Problem343 {
    public static void main(String[] args) {

        Problem343 p = new Problem343();
        System.out.println(p.integerBreak(20));
    }

    public int integerBreak(int n) {

        int [] dp = new int [n+1] ;

        dp[1] = 1;
        dp[2] = 1;
        return integerBreak(n, dp);
    }

    public int integerBreak(int n, int [] dp) {

        if (n <= 2) {
            return 1;
        }

        if (n == 2) {
            dp[2] = 1;
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int result = -1;

        for (int i = 1 ; i<= n/2 ; i++) {
            result = Math.max(result, Math.max(i, integerBreak(i, dp)) * Math.max(n - i, integerBreak(n - i, dp)));
        }
        dp[n] = result;
        return result;
    }
}
