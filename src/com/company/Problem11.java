package com.company;

public class Problem11 {

    public int minArray(int[] numbers) {
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            min = Math.min(min, num);
        }

        return min;
    }
}
