package com.company;

import java.util.HashMap;
import java.util.Map;

public class ProblemCoin1 {

    int[] arr = new int[]{ 25, 10, 5, 1 };
    //int[] arr = new int[]{ 5,2,1 };
    Map<String, Integer> map = new HashMap<>();

    public int waysToChange(int n) {

        return waysToChange(arr, 0, n, map);
    }

    public int waysToChange(int[] arr, int index, int rest, Map<String, Integer> map) {
        String key = String.format("%d_%d", index, rest);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (rest < 0) {

            map.put(key, 0);
            return 0;
        }
        if (rest == 0 && index == arr.length) {
            map.put(key, 1);
            return 1;
        }
        if (rest != 0 && index == arr.length) {
            map.put(key, 0);
            return 0;
        }

        int a = 0;
        for (int i = 0; arr[index] * i <= rest; i++) {
            a += waysToChange(arr, index + 1, rest - arr[index] * i, map);
        }

        map.put(key, a);
        return a;
    }

    public int waysToChange(int[] arr, int index, int rest, int[][] dp) {

        if (rest < 0) {

            return 0;
        }
        if (rest == 0 && index == arr.length) {
            return 1;
        }
        if (rest != 0 && index == arr.length) {
            return 0;
        }

        int a = 0;
        for (int i = 0; arr[index] * i <= rest; i++) {
            a += waysToChange(arr, index + 1, rest - arr[index] * i, map);
        }

        return a;
    }


    public static void main(String[] args) {
        ProblemCoin1 p = new ProblemCoin1();
        for (int i = 0 ; i<200 ; i+=5) {
            System.out.println(i + "\t" + p.waysToChange(i));
        }
    }
}
