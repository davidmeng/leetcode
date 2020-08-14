package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem696 {

    public static void main(String[] args) {
        Problem696 p = new Problem696();
        long start = System.currentTimeMillis();
        System.out.println(p.countBinarySubstrings(TestCase696.str));
        System.out.println("cost " + (System.currentTimeMillis() - start));
    }

    public int countBinarySubstrings(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int sum = 0;
        List<Integer> list = initList(s.getBytes());
        for (int i = 1; i < list.size(); i++) {
            sum += Math.min(list.get(i - 1), list.get(i));
        }

        return sum;
    }

    public List<Integer> initList(byte[] s) {
        List<Integer> list = new ArrayList<>(100);
        byte b = s[0];

        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (b == s[i]) {
                index++;
            } else {
                b = s[i];
                list.add(index);
                index = 1;
            }
        }
        list.add(index);

        return list;
    }
}
