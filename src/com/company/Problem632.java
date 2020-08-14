package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem632 {

    private class Node implements Comparable<Node>{
        int value ;
        int index ;

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        Problem632 p = new Problem632();

        int[] result = p.smallestRange(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        List<Integer> index = new ArrayList<>(nums.size());
        for (int i = 0 ; i<nums.size() ; i++) {
            index.add(0);
        }

        int minIndex = getMinIndex(nums, index);
        int maxIndex = getMaxIndex(nums, index);

        int start = nums.get(minIndex).get(0);
        int end = nums.get(getMaxIndex(nums, index)).get(0);


        while (true) {
            index.set(minIndex, index.get(minIndex) + 1);
            if (index.get(minIndex) == nums.get(minIndex).size()) {
                break;
            }

            minIndex = getMinIndex(nums, index);
            maxIndex = getMaxIndex(nums, index);

            int tStart = nums.get(minIndex).get(index.get(minIndex));
            int tEnd = nums.get(maxIndex).get(index.get(maxIndex));

            if ((tEnd - tStart) < (end - start)) {
                end = tEnd;
                start = tStart;
            }
        }

        return new int[]{start, end};
    }

    private int getMinIndex(List<List<Integer>> nums, List<Integer> index) {
        int minValue = Integer.MAX_VALUE;
        int indexValue = -1;
        for (int i = 0; i < index.size(); i++) {
            if (minValue > nums.get(i).get(index.get(i))) {
                minValue = nums.get(i).get(index.get(i));
                indexValue = i;
            }
        }

        return indexValue;
    }

    private int getMaxIndex(List<List<Integer>> nums, List<Integer> index) {
        int maxValue = Integer.MIN_VALUE;
        int indexValue = -1;
        for (int i = 0; i < index.size(); i++) {
            if (maxValue < nums.get(i).get(index.get(i))) {
                maxValue = nums.get(i).get(index.get(i));
                indexValue = i;
            }
        }

        return indexValue;
    }


}
