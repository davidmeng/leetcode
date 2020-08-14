package com.company;

public class Problem96 {

    public static void main(String[] args) {
        Problem96 p = new Problem96();
        System.out.println(p.numTrees(3));
    }

    public int numTrees(int n) {

        int[] arr = new int[n + 1];
        return dp(n, arr);
    }

    public int dp(int treeNode, int[] arr) {
        if (arr[treeNode] != 0) {
            return arr[treeNode];
        }

        if (treeNode <= 1) {
            arr[treeNode] = 1;
            return 1;
        }

        int result = 0;
        for (int i = 0; i < treeNode; i++) {
            result += dp(i, arr) * dp(treeNode - 1 - i, arr);
        }

        arr[treeNode] = result;
        return arr[treeNode];
    }
}
