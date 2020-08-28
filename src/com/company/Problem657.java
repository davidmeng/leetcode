package com.company;

public class Problem657 {

    public boolean judgeCircle(String moves) {

        if (moves.length() == 0) {
            return true;
        }

        if ((moves.length() & 1) == 1) {
            return false;
        }

        int i = 0, j = 0;
        byte[] arr = moves.getBytes();
        for (byte b : arr) {
            switch (b) {
                case 'U': {
                    i++;
                    break;
                }
                case 'D': {
                    i--;
                    break;
                }
                case 'L': {
                    j--;
                    break;
                }
                case 'R': {
                    j++;
                    break;
                }
            }
        }

        if (i == 0 && j == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Problem657 p = new Problem657();
        System.out.println(p.judgeCircle("LRUD"));
    }
}
