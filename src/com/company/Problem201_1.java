package com.company;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Problem201_1 {

    public static void main(String[] args) {
        Problem201_1 p = new Problem201_1();
        System.out.println(p.rangeBitwiseAnd(2147483646,
                2147483647));
    }

    public int rangeBitwiseAnd(int m, int n) {

        int tm = m , tn = n;

        int i = 0 ;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }

        return m<<i;
    }
}
