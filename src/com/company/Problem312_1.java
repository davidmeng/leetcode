package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Problem312_1 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        Problem312_1 p = new Problem312_1();
        System.out.println(p.maxCoins(new int[]{8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5,5}));

        System.out.println("total cost: " + (System.currentTimeMillis() - start));
    }

    public int maxCoins(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Map<String , Integer> map = new HashMap<>();
        LinkedList<Integer> numList = new LinkedList<>();
        for (Integer num : nums) {
            numList.add(num);
        }

        return maxCoins(numList, 0, map);
    }

    public int maxCoins(LinkedList<Integer> numList, int sum, Map<String, Integer> cache) {

        Integer max = cache.get(getKey(numList));
        if (max != null) {
            return max + sum;
        }

        if (numList.size() == 1) {
            int maxNumber = sum + numList.get(0);
            cache.put(getKey(numList), numList.get(0));
            return maxNumber;
        } else {
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < numList.size(); i++) {
                int value  = numList.get(i);
                if (i > 0) {
                    value = value * numList.get(i - 1);
                }

                if (i < numList.size() - 1) {
                    value = value * numList.get(i + 1);
                }
                int temp = numList.remove(i);
                maxSum = Math.max(maxCoins(numList, sum + value, cache), maxSum);
                numList.add(i, temp);
            }
            cache.put(getKey(numList), maxSum - sum);
            return maxSum;
        }
    }

    public String getKey(LinkedList<Integer> numList) {
        StringBuffer sb = new StringBuffer();
        for (int number: numList) {
            sb.append(number).append("_");
        }
        return sb.toString();
    }
}
