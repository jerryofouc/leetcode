package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/3/17.
 */
public class GameOfLife {
    public static void gameOfLife(int[][] board) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int num = getNeighborLive(board,i,j);
                if(board[i][j] == 0 && num ==3){
                   board[i][j] = 2;
                }
                if(board[i][j] == 1){
                    if(num>=2&&num<=3){
                        board[i][j] = 3;
                    }
                }
            }
        }


        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] = board[i][j]>>1;
            }
        }

    }

    private static int getNeighborLive(int[][] board, int i, int j) {
        int liveSum = 0;

        if(i-1>=0&&j-1>=0){
            if((board[i-1][j-1]&1) == 1){
                liveSum++;
            }
        }

        if(i-1>=0){
            if((board[i-1][j]&1) == 1){
                liveSum++;
            }
        }

        if(j-1>=0){
            if((board[i][j-1]&1) == 1){
                liveSum++;
            }
        }

        if(j-1>=0&&i+1<board.length){
            if((board[i+1][j-1]&1) == 1){
                liveSum++;
            }
        }

        if(i+1<board.length){
            if((board[i+1][j]&1) == 1){
                liveSum++;
            }
        }

        if(i+1<board.length&&j+1<board[0].length){
            if((board[i+1][j+1]&1) == 1){
                liveSum++;
            }
        }

        if(j+1<board[0].length){
            if((board[i][j+1]&1) == 1){
                liveSum++;
            }
        }

        if(j+1<board[0].length && i-1>=0){
            if((board[i-1][j+1]&1) == 1){
                liveSum++;
            }
        }
        return liveSum;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0}
        };
        gameOfLife(board);
    }
}
