package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/25/17.
 */
public class Minesweeper {
    public static char[][] updateBoard(char[][] board, int[] click) {
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else if (board[row][col] == 'E') {
            int sum = 0;
            for (int j = 0; j < direction.length; j++) {
                int curI = row + direction[j][0];
                int curJ = col + direction[j][1];
                if (curI >= 0 && curI < board.length && curJ >= 0 && curJ < board[0].length && board[curI][curJ] == 'M') {
                    sum++;
                }
            }
            if (sum != 0) {
                board[row][col] = (char) ('0' + sum);
            } else {
                board[row][col] = 'B';
                for (int j = 0; j < direction.length; j++) {
                    int curI = row + direction[j][0];
                    int curJ = col + direction[j][1];
                    if (curI >= 0 && curI < board.length && curJ >= 0 && curJ < board[0].length && board[curI][curJ] == 'E') {
                        updateBoard(board, new int[]{curI, curJ});
                    }
                }
            }
        }

        return board;

    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'} };
        System.out.println(updateBoard(board,new int[]{3,0}));
        System.out.println("aaa");
    }
}
