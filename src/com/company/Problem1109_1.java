package com.company;

import java.util.*;

public class Problem1109_1 {
    public static void main(String[] args) {
        Problem1109_1 p = new Problem1109_1();
        int[] arr = p.corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
        System.out.println(Arrays.toString(arr));
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {


        TreeSet<Integer> set = new TreeSet<>();


        // index, value
        for (int i = 0; i < bookings.length; i++) {
            set.add(bookings[i][0]);
            set.add(bookings[i][1]);
        }

        Integer [] indexes = set.toArray(new Integer[]{});

        // index, ture index
        TreeMap<Integer, Integer> mapIndex = new TreeMap<>();
        int t = 0;
        for (Iterator<Integer> itor = set.iterator(); itor.hasNext(); ) {
            mapIndex.put(itor.next(), t++);
        }

        int arr[] = new int [mapIndex.size()] ;
        for (int i = 0; i < bookings.length; i++) {
            for (int j = bookings[i][0]; j <= bookings[i][1]; j++) {
                arr[mapIndex.get(j)] += bookings[i][2];
            }
        }

        int pre = 1;
        int result [] = new int[n];
        for (int i = 0; i<indexes.length; i++) {
            for (int j = pre ;j<=indexes[i];j++) {
                result[pre-1] = arr[i];
            }
        }

        return result;
    }
}
