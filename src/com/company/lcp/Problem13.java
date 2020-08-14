package com.company.lcp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Problem13 {

    public static void main(String[] args) {
        Problem13 p = new Problem13();
        p.minimalSteps(new String [] {"S#O", "M..", "M.T"});
    }

    private int[][] directs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimalSteps(String[] maze) {
        int length = initLength(maze);
        int [][] elements = initElementArray(maze, length);
        int [][] distance = initPath(maze, length, elements);
        char[] charElement = initElement(maze, length);
        boolean [] visit = new boolean[length];
        int count = countM(charElement);

        while (count-->0) {
            for (int i = 0 ; i<visit.length ; i++) {

            }
        }

        for (int i = 0 ; i<distance.length ; i++) {
            for (int j = 0 ; j<distance[i].length ; j++){
                System.out.printf("%d ", distance[i][j]);
            }
            System.out.println();
        }


        return 1;
    }

    public int countM(char[] chars) {
        int count = 0;
        for (char c:chars) {
            if (c=='O') {
                count++;
            }
        }
        return count;
    }

    public char[] initElement(String[] maze, int length) {
        char[] result = new char[length];
        int index = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                char s = maze[i].charAt(j);
                if (s == 'S' || s == 'T' || s == 'O' || s == 'M') {
                    result[index++] = s;
                }
            }
        }

        return result;
    }

    public int initLength(String[] maze) {

        int result = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                char s = maze[i].charAt(j);
                if (s == 'S' || s == 'T' || s == 'O' || s == 'M') {
                    result++;
                }
            }
        }

        return result;
    }

    public int[][] initElementArray(String[] maze, int length) {

        int[][] arr = new int[maze.length][maze[0].length()];
        int index = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                char s = maze[i].charAt(j);
                if (s == 'S' || s == 'T' || s == 'O' || s == 'M') {
                    arr[i][j] = index++;
                }
            }
        }

        return arr;
    }

    public int[][] initPath(String[] maze, int length, int[][] elements) {
        int[][] result = new int[length][length];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length(); j++) {
                char s = maze[i].charAt(j);
                if (s == 'S' || s == 'T' || s == 'O' || s == 'M') {
                    initPath(maze, i, j, elements, length, result);
                }
            }
        }

        return result;
    }

    public void initPath(String[] maze, int row, int col, int[][] elements, int length, int[][] distance) {

        LinkedList<Integer> rowList = new LinkedList<>();
        LinkedList<Integer> columnList = new LinkedList<>();
        LinkedList<Integer> stepList = new LinkedList<>();
        stepList.push(0);
        rowList.push(row);
        columnList.push(col);

        Set<String> set = new HashSet<>();
        set.add(row+"_"+col);

        while (!rowList.isEmpty()) {
            int tempRow = rowList.pop();
            int tempCol = columnList.pop();
            int step = stepList.pop();
            step++;

            for (int i = 0; i < directs.length; i++) {
                int row1 = tempRow + directs[i][0];
                int col1 = tempCol + directs[i][1];

                if (row1 >= 0 && col1 >= 0 && row1 < maze.length && col1 < maze[0].length()) {

                    String key = row1 + "_" + col1;
                    if (!set.contains(key)) {
                        char t = maze[row1].charAt(col1);
                        if (t == '#') {
                            continue;
                        }

                        if (t == 'S' || t == 'T' || t == 'O' || t == 'M') {
                            distance[elements[row][col]][elements[row1][col1]] = step;
                            distance[elements[row1][col1]][elements[row][col]] = step;
                        }

                        stepList.addLast(step);
                        rowList.addLast(row1);
                        columnList.addLast(col1);
                        set.add(key);
                    }
                }
            }
        }
    }


}
