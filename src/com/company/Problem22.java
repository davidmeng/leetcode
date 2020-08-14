package com.company;

import java.util.ArrayList;
import java.util.List;

public class Problem22 {

    public static void main(String[] args) {
        Problem22 p = new Problem22();
        List<String> result = p.generateParenthesis(4);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateParenthesis(n, new StringBuffer(), 0, 0, new ArrayList<>(), false);
    }


    public List<String> generateParenthesis(int n, StringBuffer str, int left, int right, List<String> result, boolean addLeft) {
        if (n == left && n == right) {

            result.add(str.toString());
            return result;
        }

        StringBuffer sb = new StringBuffer(str.toString());
        if (!addLeft) {

            for (int i = left + 1; i <= n; i++) {
                sb.append("(");
                generateParenthesis(n, sb, i, right, result, true);
            }
        } else {
            for (int i = right + 1; i <= left; i++) {
                sb.append(")");
                generateParenthesis(n, sb, left, i, result, false);
            }
        }

        return result;
    }
}
