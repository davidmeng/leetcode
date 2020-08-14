package com.company;

public class Problem1024 {

    public int videoStitching(int[][] clips, int T) {

        if (!canFinish(clips,T)) {
            return -1;
        }

        int [] arr = initArr(clips, T);
        int index = 1;
        int end = arr[0];
        //int start = 0;

        while(end < T) {
            index++;
            int t = end;
            for (int i = 0; i<=end ; i++ ) {
                t = Math.max(t, arr[i]);
            }

            if (t == end) {
                return -1;
            }

            end = t;
        }

        return index;
    }

    private boolean canFinish(int[][] clips, int T) {
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][1] >= T) {
                return true;
            }
        }
        return false;
    }

    private int[] initArr(int[][] clips, int T) {
        int[] arr = new int[T + 1];
        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] <= T) {
                arr[clips[i][0]] = Math.max(arr[clips[i][0]], clips[i][1]);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Problem1024 p = new Problem1024();
        System.out.println(p.videoStitching(new int [][] {{5,7},{1,8},{0,0},{2,3},{4,5},{0,6},{5,10},{7,10}}, 5));
    }
}
