package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-08 11:20
 *         功能介绍:
 */
public class WordSearch {


    public static boolean exist(char[][] board, String word) {
        char[] wc = word.toCharArray();
        int height = board.length;
        int width = board[0].length;
        boolean hasPass[][] = new boolean[height][width];

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(find(wc,0,board,i,j,hasPass)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean find(char[] wc, int curIndex, char[][] board, int i, int j, boolean[][] hasPass) {
        if(curIndex >= wc.length){
            return true;
        }

        //in board
        if(i >= board.length || i<0  ||j >= board[i].length||j<0){
            return false;
        }


        if(!hasPass[i][j] && wc[curIndex] == board[i][j]){
            hasPass[i][j] = true;
            if( find(wc,curIndex+1,board,i,j+1, hasPass)){
                return true;
            }

            if( find(wc,curIndex+1,board,i+1,j, hasPass)){
                return true;
            }

            if( find(wc,curIndex+1,board,i,j-1, hasPass)){
                return true;
            }

            if( find(wc,curIndex+1,board,i-1,j, hasPass)){
                return true;
            }
            hasPass[i][j] = false;
        }

        return false;
    }

    public static void main(String args[]){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        System.out.println(exist(board,"ABCCED"));
    }
}
