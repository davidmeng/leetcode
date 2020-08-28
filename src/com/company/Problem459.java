package com.company;

public class Problem459 {
    public boolean repeatedSubstringPattern(String s) {

        if (s.length() <= 1) {
            return false;
        }

        byte arr[] = s.getBytes();
        int l = s.length();
        for (int i = 1; i < s.length(); i++) {
            if (l % i == 0) {
                boolean isR = repeatedSubstringPattern(arr, i);
                if (isR) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean repeatedSubstringPattern(byte[] arr, int length) {

        byte first = arr[0];
        int times = arr.length / length;
        for (int j = 0; j < length; j++) {
            for (int i = 0 ; i<times; i++) {
                if (i ==0) {
                    first = arr[j];
                } else {
                    if (first != arr[length * i + j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem459 p = new Problem459();
        System.out.println(p.repeatedSubstringPattern("abcabcabcabc"));
    }
}
