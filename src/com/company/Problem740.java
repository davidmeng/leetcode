package com.company;

public class Problem740 {

    public static void main(String[] args) {
        Problem740 p = new Problem740();
        System.out.println(p.deleteAndEarn(new int [] {10000,9999,9998}));
    }

    public int deleteAndEarn(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int [] arr = init(nums);
        int [] sum = new int [arr.length];

        for (int i = arr.length - 3 ; i>=1; i--) {
            sum[i] = Math.max(arr[i]+sum[i+2], sum[i+1]);
        }

        return sum[1];
    }

    public int[] init (int[] nums) {

        int [] arr = new int [10003];
        for (int num: nums) {
            arr[num] += num;
        }

        return arr;
    }

    public int sum(int[] nums, int start) {
        int sum = 0 ;
        sum = Math.max(nums[start]+sum(nums, start+2) , sum(nums, start+1));
        return sum;
    }

}
