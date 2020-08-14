package com.company;

import java.util.*;

public class Problem130 {

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    List<Integer> visiti = new ArrayList<>();
    List<Integer> visitj = new ArrayList<>();
    LinkedList<Integer> listi = new LinkedList<>();
    LinkedList<Integer> listj = new LinkedList<>();



    public void solve(char[][] board) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    visit(board, i, j);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void visit(char[][] board, int i, int j) {

        visiti.clear();
        visitj.clear();
        listi.clear();
        listj.clear();

        boolean canTouch = false;


        listi.add(i);
        listj.add(j);

        visiti.add(i);
        visitj.add(j);

        while (listi.size() > 0) {
            i = listi.pop();
            j = listj.pop();
            //board[i][j] = 'A';

            if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                canTouch = true;
            }

            for (int t = 0; t < dx.length; t++) {
                int ii = i + dx[t];
                int jj = j + dy[t];

                if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && board[ii][jj] == 'O' ) {
                    visiti.add(ii);
                    visitj.add(jj);

                    listi.add(ii);
                    listj.add(jj);

                    if (ii == 0 || jj == 0 || ii == board.length - 1 || jj == board[0].length - 1) {
                        canTouch = true;
                    }

                    board[ii][jj] = 'A';
                }
            }
        }

        if (!canTouch) {
            for (int k = 0; k < visiti.size(); k++) {
                board[visiti.get(k)][visitj.get(k)] = 'X';
            }
        }

    }




    public static void main(String[] args) {
        Problem130 p = new Problem130();
        //char [][] board =  {{'O','O'},{'O','O'}};
        char [][] board =  {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //
        p.solve(board);

        for (int i = 0 ; i<board.length ; i++) {
            for (int j = 0 ; j<board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


}
