package com.company;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

public class Problem17 {

    private static char [][] arr = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public List<String> letterCombinations(String digits) {
        StringBuffer sb = new StringBuffer();
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
/*

        for (int i = 0 ; )
*/

        return list;
    }

    public StringBuffer letterCombinations(String digits, int i, int j, StringBuffer sb) {
        if (i == digits.length()) {
            return sb;
        }

        int jIndex = arr[digits.charAt(i) - '2'].length;
        if (j == jIndex) {
            return letterCombinations(digits, i+1, 0, sb);
        }

        sb.append(arr[digits.charAt(i) - '2'][j]);
        return letterCombinations(digits, i, j+1, sb);
    }
}
