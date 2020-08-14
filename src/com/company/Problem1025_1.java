package com.company;

public class Problem1025_1 {

    public static void main(String[] args) {
        Problem1025_1 p = new Problem1025_1();
        for(int i = 1 ; i<=1000 ; i++) {
            System.out.printf("the number is %d, she can win: %s\n" , i , String.valueOf(p.divisorGame(i)) );
        }
    }


    public boolean divisorGame(int N) {

        if ((N & 1) == 1) {
            return false;
        }

        return true;
    }
}
