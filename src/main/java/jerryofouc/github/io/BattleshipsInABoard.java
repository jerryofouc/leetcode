package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/10/17.
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return 0;
        }
        int result = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'X' && (i-1<0||board[i-1][j] == '.')){
                    result++;
                    while (j+1<board[0].length&&board[i][j+1] == 'X'){
                        j++;
                    }
                }
            }
        }
        return result;
    }
}
