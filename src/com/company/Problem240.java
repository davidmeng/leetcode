package com.company;

import java.util.HashMap;
import java.util.Map;

public class Problem240 {

    public static void main(String[] args) {
        Problem240 p = new Problem240();

        int [][] arr = {{1,3}};

        System.out.println(p.searchMatrix(arr, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return findLess(0, 0, matrix.length - 1, matrix[0].length - 1, matrix, target);
    }

    public boolean findLess(int starti, int startj, int endi, int endj, int[][] matrix, int target) {


        if (starti > endi || startj > endj) {

            return false;
        }

        if (startj >= matrix[0].length || starti >= matrix.length) {

            return false;
        }

        if (matrix[starti][startj] > target || matrix[endi][endj] < target) {
            return false;
        }

        if (starti == endi && startj == endj) {
            if (matrix[starti][startj] == target) {
                return true;
            }
            return false;
        }



        int midi = starti + (endi - starti) / 2;
        int midj = startj + (endj - startj) / 2;

        if (matrix[midi][midj] == target) {
            return true;
        } else if (target > matrix[midi][midj]) {
            boolean result = findLess(midi + 1, midj + 1, endi, endj, matrix, target)
                    || findLess(midi + 1, startj, endi, midj, matrix, target)
                    || findLess(starti, midj + 1, midi, endj, matrix, target);
            return result;

        } else {
            boolean result = findLess(starti, startj, midi, midj, matrix, target)
                    || findLess(midi + 1, startj, endi, midj, matrix, target)
                    || findLess(starti, midj + 1, midi, endj, matrix, target);
            return result;
        }
    }
}
