package jerryofouc.github.io;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/28/14
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class SurroundedRegions {


    private static class Pair {
        private Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        private Pair() {
        }

        int row;
        int col;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (col != pair.col) return false;
            if (row != pair.row) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }
    private static void traverse(int row, int i, char[][] board) {
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(row, i));
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            board[p.row][p.col] = 'E';
            if (p.row - 1 > 0 && board[p.row - 1][p.col] == 'O') {
                stack.push(new Pair(p.row - 1, p.col));
            }
            if (p.row + 1 != board.length && board[p.row + 1][p.col] == 'O') {
                stack.push(new Pair(p.row + 1, p.col));
            }
            if (p.col - 1 > 0 && board[p.row][p.col - 1] == 'O') {
                stack.push(new Pair(p.row, p.col - 1));
            }
            if (p.col + 1 != board[p.row].length && board[p.row][p.col + 1] == 'O') {
                stack.push(new Pair(p.row, p.col + 1));
            }
        }
    }


    public static void solve(char[][] board) {
        if(board == null || board.length == 0){
            return ;
        }
        int rows[] = {0, board.length - 1};
        for (int i = 0; i < board[0].length; i++) {
            for (int row : rows) {
                if (board[row][i] == 'O') {
                    traverse(row, i, board);
                }
            }
        }

        int cols[] = {0,board[0].length-1};
        for(int i=0;i<board.length;i++){
            for(int col:cols){
                if(board[i][col] == 'O'){
                    traverse(i, col, board);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 'E'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void main(String args[]){
        char board[][]  = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'},
        };
        solve(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }

    }



}
