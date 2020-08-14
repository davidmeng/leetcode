package com.company;

import java.util.LinkedList;

public class Problem20 {

    public static void main(String[] args) {
        Problem20 p = new Problem20();
        System.out.println(p.isValid("(]"));
    }

    public boolean isValid(String s) {

        if (s.length() == 0) {
            return true;
        }

        byte [] bytes = s.getBytes();
        LinkedList<Byte> linkedList = new LinkedList<>();
        for (byte b : bytes) {
            if (b == '(' || b == '[' || b=='{') {
                linkedList.addLast(b);
            }

            else if (b == ')') {
                if (linkedList.size() > 0 && linkedList.peekLast()== '(') {
                    linkedList.pollLast();
                } else {
                    return false;
                }
            }

            else if (b == ']') {
                if (linkedList.size() > 0 && linkedList.peekLast()== '[') {
                    linkedList.pollLast();
                } else {
                    return false;
                }
            }

            else if (b == '}') {
                if (linkedList.size() > 0 && linkedList.peekLast()== '{') {
                    linkedList.pollLast();
                } else {
                    return false;
                }
            }
        }

        return linkedList.size() == 0;
    }
}
