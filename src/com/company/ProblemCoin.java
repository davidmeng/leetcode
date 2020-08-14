package com.company;

public class ProblemCoin {

    static int[][] arr = new int[4][1000];
    static boolean isInit = false;


    private int[][] init() {

        if (isInit) {
            return arr;
        }
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = 1;
        }

        for (int i = 0; i < arr[0].length; i++) {
            arr[1][i] = arr[0][i];
            if (i % 5 == 0) {
                if (i >= 5) {
                    arr[1][i] += arr[1][i - 5];
                }
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            arr[2][i] = arr[1][i];
            if (i % 10 == 0) {
                if (i >= 10) {
                    arr[2][i] += arr[2][i - 10];
                }
            }
        }

        for (int i = 0; i < arr[0].length; i++) {
            arr[3][i] = arr[2][i];
            if (i % 25 == 0) {
                if (i >= 25) {
                    arr[3][i] += arr[3][i - 25];
                }
            }
        }
        isInit = true;
        return arr;
    }

    public int waysToChange(int n) {
        int[][] arr = init();
        return arr[3][n];
    }

    public static void main(String[] args) {
        ProblemCoin p = new ProblemCoin();
        p.init();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }

}
