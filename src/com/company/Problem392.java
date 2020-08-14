package com.company;

public class Problem392 {

    public static void main(String[] args) {
        Problem392 p = new Problem392();
        System.out.println(p.isSubsequence("aaa", "aaa"));
        System.out.println(p.isSubsequence("", "abcd"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        if (t.length() == 0) {
            return false;
        }

        return find(s,t,0,0);
    }

    public boolean find (String s , String t, int i, int l) {
        if (i == s.length()) {
            return true;
        }

        int target = t.indexOf(s.charAt(i), l);
        if (target == -1 ) {
            return false;
        }

        return find(s, t, i+1, target+1);
    }
}
