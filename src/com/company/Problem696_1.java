package com.company;

import java.util.ArrayList;
import java.util.List;

public class Problem696_1 {

    public static void main(String[] args) {
        Problem696_1 p = new Problem696_1();
        long start = System.currentTimeMillis();
        System.out.println(p.countBinarySubstrings(TestCase696.str));
        System.out.println("cost " + (System.currentTimeMillis() - start));
    }

    public int countBinarySubstrings(String str) {

        if (str.length() == 0) {
            return 0;
        }

        int sum = 0;
        byte [] s = str.getBytes();

        int preSum = 0 ;
        byte b = s[0];

        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (b == s[i]) {
                index++;
            } else {
                b = s[i];
                sum += Math.min(preSum, index);
                preSum = index;
                index = 1;
            }
        }

        sum+=Math.min(preSum, index);

        return sum;
    }
}
