package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1218 {

    public int longestSubsequence(int[] arr, int difference) {

        if (arr.length == 0) {
            return 0;
        }
        return longestSubsequence(arr,0, difference, new int [arr.length]);
    }

    public int longestSubsequence(int[] arr, int index, int difference, int [] count) {
        if (index == arr.length) {
            int max = 0 ;
            for (int c: count) {
                max = Math.max(max, c);
            }
            return max;
        }

        int max = 1 ;
        for (int i = 0 ; i<=index ; i++) {
            if (arr[i] + difference == arr[index]) {
                max = Math.max(max, count[i] + 1);
            }
        }
        count[index] = max;


        return longestSubsequence(arr, index+1, difference, count);
    }

    static int [ ] para = new int[] {1,3,5,7};

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("d:", "testcase", "1218.txt"), StandardCharsets.UTF_8);
        String line = lines.get(0);
        String [] nums = line.split(",");
        int [] num = new int [nums.length];
        for (int i = 0 ; i<nums.length ; i++) {
            num[i] = Integer.parseInt(nums[i]);
        }

        Problem1218 p = new Problem1218();
        long start = System.currentTimeMillis();
        System.out.println(p.longestSubsequence(num, 5692));
        System.out.printf("cost %d.\n", System.currentTimeMillis()-start);
    }
}
