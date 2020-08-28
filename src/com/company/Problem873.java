package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem873 {

    public int lenLongestFibSubseq(int[] A) {

        Set<String> set = new HashSet<>();

        int max = 0;
        for (int i = 0; i < A.length; i++) {

            for (int j = i + 1; j < A.length; j++) {
                int count = 2;

                int a1 = A[i];
                int a2 = A[j];
                int a3 = a1 + a2;

                if (set.contains(getKey(a1,a2,a3))) {
                    continue;
                }

                int index = Arrays.binarySearch(A, a3);

                while (index >= 0) {
                    set.add(getKey(a1,a2,a3));

                    count++;
                    a1 = a2;
                    a2 = a3;
                    a3 = a1 + a2;

                    index = Arrays.binarySearch(A, a3);

                    max = Math.max(max, count);
                }
            }
        }

        return max;
    }

    private String getKey(int a1, int a2, int a3) {
        return a1 + "_" + a2 + "_" + a3;
    }

    public static void main(String[] args) {
        Problem873 p = new Problem873();
        System.out.println(p.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
