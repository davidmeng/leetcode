package com.company;

public class Problem375 {

    public static void main(String[] args) {
        Problem375 p = new Problem375();
        System.out.println(p.getMoneyAmount(5));
    }

    public int getMoneyAmount(int n) {
        return getMoneyAmount(1, n , 0);
    }

    public int getMoneyAmount(int s, int e , int total) {
        if (s == e-1) {
            return total + s;
        }

        if (s == e-2) {
            return total + s;
        }

        for (int i = e-1; i>s ; i--) {
            if (sum(i+1, e) > sum(s,i-1)) {
                return getMoneyAmount(i+1, e, total + i);
            }
        }

        return total + s;
    }

    public int sum(int s, int e) {
        int t = 0 ;
        for (int i = s; i<=e ; i++) {
            t+=i;
        }

        return t;
    }

}
