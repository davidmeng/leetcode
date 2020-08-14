package com.company;

import java.util.Arrays;
import java.util.TreeMap;

public class Problem1109 {
    public static void main(String[] args) {
        Problem1109 p = new Problem1109();
        int[] arr = p.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
        System.out.println(Arrays.toString(arr));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] arr = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                arr[j - 1] += bookings[i][2];
            }
        }

        return arr;
    }
}
