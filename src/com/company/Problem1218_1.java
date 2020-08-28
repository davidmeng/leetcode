package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1218_1 {

    public int longestSubsequence(int[] arr, int difference) {

        if (arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0 ; index<arr.length; index++) {
            int max = 1 ;
            for (int i = index- 1 ; i>=0 ; i--) {
                if (map.containsKey(arr[i]) && arr[i] + difference == arr[index]) {
                    max = Math.max(max, map.get(arr[i]) + 1);
                }
            }
            if (map.containsKey(map.get(arr[index]))) {
                max = Math.max(map.get(arr[index]), max);
            }
            map.put(arr[index], max);
            map.remove(arr[index] - difference);
        }

        int max = 1 ;
        for (int key: map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return max;
    }

    static int [ ] para = new int[] {1,2,3,4};

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\testcase\\1218.txt");
        List<String> lines = Files.readAllLines(Paths.get("d:", "testcase", "1218.txt"), StandardCharsets.UTF_8);
        String line = lines.get(0);
        String [] nums = line.split(",");
        int [] num = new int [nums.length];
        for (int i = 0 ; i<nums.length ; i++) {
            num[i] = Integer.parseInt(nums[i]);
        }
        System.out.println("start");
        Problem1218_1 p = new Problem1218_1();
        long start = System.currentTimeMillis();
        System.out.println(p.longestSubsequence(num, 5692));
        System.out.printf("cost %d.\n", System.currentTimeMillis()-start);
    }
}
