package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem632_1 {

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));


        Problem632_1 p = new Problem632_1();

        int[] result = p.smallestRange(nums);
        System.out.println(Arrays.toString(result));
    }


    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (int i = 0 ; i<nums.size() ; i++) {
            Node n = new Node();
            n.queueIndex = i ;
            n.value = nums.get(i).get(0);
            priorityQueue.add(n);
        }


        int end = getMax(nums);
        int tMax = end;

        Node small = priorityQueue.poll();
        int start = small.value;

        while (true) {

            if (nums.get(small.queueIndex).size() <= small.numberIndex + 1) {
                break;
            }

            int next = nums.get(small.queueIndex).get(small.numberIndex + 1);
            small.value = next;
            small.numberIndex++;
            priorityQueue.add(small);


            tMax = Math.max(tMax, next);
            int tStart = priorityQueue.peek().value;
            int tEnd = tMax;

            if ((tEnd - tStart) < (end - start)) {
                end = tEnd;
                start = tStart;
            }
            small = priorityQueue.poll();
        }

        return new int[]{start, end};
    }

    private int getMax(List<List<Integer>> nums) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0 ; i<nums.size() ; i++) {
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }

        return maxValue;
    }

    private class Node implements Comparable<Node>{
        int value ;
        int queueIndex ;
        int numberIndex ;

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
