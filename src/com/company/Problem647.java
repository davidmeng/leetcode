package com.company;

public class Problem647 {

    public int countSubstrings(String s) {

        int count = 0;
        byte [] bytes = s.getBytes();
        for (int i=0 ; i<bytes.length ; i++) {
            for (int j = i ; j<bytes.length ;j++) {
                if (isPalindromic(bytes, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPalindromic (byte [] bytes, int start, int end) {
        if (start == end) {
            return true;
        }

        while (start < end) {
            if (bytes[start++] != bytes[end--]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem647 p = new Problem647();
        System.out.println(p.countSubstrings("aaa"));
    }
}
