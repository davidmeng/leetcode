package com.company;

public class Problem415 {

    public static void main(String[] args) {
        Problem415 p = new Problem415();
        System.out.println(p.addStrings("9133", "0"));
    }

    public String addStrings(String num1, String num2) {

        return convertToStr(add(convertToArray(num1), convertToArray(num2)));
    }

    private int[] convertToArray(String num) {
        int[] arr = new int[num.length()];

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[num.length() - i - 1] = Integer.valueOf(num.charAt(i) - '0');
        }

        return arr;
    }

    private int[] add(int[] num1, int[] num2) {
        int maxLength = Math.max(num1.length, num2.length);
        int minLength = Math.min(num1.length, num2.length);

        int[] result = new int[maxLength + 1];
        int a = 0;
        for (int i = 0; i < maxLength; i++) {
            result[i] = (getValue(num1, i) + getValue(num2, i) + a) % 10;
            a = (getValue(num1, i) + getValue(num2, i) + a) / 10;
        }

        result[result.length - 1] = a;

        return result;
    }

    private int getValue(int[] num1, int start) {
        if (num1.length <= start) {
            return 0;
        }

        return num1[start];
    }

    private String convertToStr(int[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1 && arr[i] == 0) {
                continue;
            }
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
