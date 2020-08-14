package com.company;

public class Problem1025 {

    public static void main(String[] args) {
        Problem1025 p = new Problem1025();
        for(int i = 1 ; i<=1000 ; i++) {
            System.out.printf("the number is %d, she can win: %s\n" , i , String.valueOf(p.divisorGame(i)) );
        }
    }

    public static boolean init = false ;
    static boolean[] arr = new boolean[1001];

    public static void initArr () {
        if (!init) {

            arr[0] = false;
            arr[1] = false;
            arr[2] = true;
            arr[3] = false;

            for (int i = 4; i <= 1001; i++) {

                for (int j = 1; j < i; j++) {
                    if (i % j == 0) {
                        if (arr[i-j] == false) {
                            arr[i] = true;
                            break;
                        }
                        int c = i/j ;
                        if (c < j) {
                            break;
                        }
                    }
                }
            }
        }
        init = true;
    }

    public boolean divisorGame(int N) {

        initArr();
        return arr[N];
    }
}
