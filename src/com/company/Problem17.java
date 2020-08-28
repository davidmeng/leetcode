package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem17 {

    private static char[][] arr = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        StringBuffer sb = new StringBuffer();
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }

        List<String> result = new ArrayList<>();
        int arr[] = new int[digits.length()];
        byte[] bytes = digits.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            arr[i] = (int) bytes[i] - '0';
        }

        letterCombinations(arr, 0, new StringBuffer(), result);

        return result;
    }

    public void letterCombinations(int[] digits, int i, StringBuffer sb, List<String> result) {

        if (i == digits.length) {
            result.add(sb.toString());
            return;
        }

        for (int j = 0; j < arr[digits[i] - 2].length; j++) {
            sb.append(arr[digits[i] - 2][j]);
            letterCombinations(digits, i + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Problem17 p = new Problem17();
        System.out.println(p.letterCombinations("2"));
    }
}
