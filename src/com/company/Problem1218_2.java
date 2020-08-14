package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1218_2 {

    public int longestSubsequence(int[] arr, int difference) {

        if (arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 1 ;
        for (int index = 0 ; index < arr.length ; index++) {

            int t = arr[index] - difference;
            if (map.containsKey(t)) {
                int result = map.get(t)+1;
                map.put(arr[index], result);
                max = Math.max(max, result);
            } else {
                map.put(arr[index], 1);
            }

        }

        return max;
    }


    static int [ ] para = new int[] {1,5,7,8,5,3,4,2,1};

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("d:", "testcase", "1218.txt"), StandardCharsets.UTF_8);
        String line = lines.get(0);
        String [] nums = line.split(",");
        int [] num = new int [nums.length];
        for (int i = 0 ; i<nums.length ; i++) {
            num[i] = Integer.parseInt(nums[i]);
        }

        Problem1218_2 p = new Problem1218_2();
        long start = System.currentTimeMillis();
        System.out.println(p.longestSubsequence(num, 5692));
        System.out.printf("cost %d.\n", System.currentTimeMillis()-start);
    }
}
