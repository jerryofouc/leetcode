package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaojiezhang on 1/6/17.
 */
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(board[i][j]>='1' &&  board[i][j]<='9'){
                    if(!set.contains(board[i][j])){
                        set.add(board[i][j]);
                    }else {
                        return false;
                    }
                }else if(board[i][j] != '.'){
                    return false;
                }

            }
            set.clear();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i]>='1' &&  board[j][i]<='9'){
                    if(!set.contains(board[j][i])){
                        set.add(board[j][i]);
                    }else {
                        return false;
                    }
                }else if(board[j][i] != '.'){
                    return false;
                }

            }
            set.clear();
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int k = i*3;k<i*3+3;k++){
                    for(int p=j*3;p<j*3+3;p++){
                        if(board[k][p]>='1' &&  board[k][p]<='9'){
                            if(!set.contains(board[k][p])){
                                set.add(board[k][p]);
                            }else {
                                return false;
                            }
                        }else if(board[k][p] != '.'){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] a = new String[]{".87654321","2........","3........","4........","5........",
                "6........","7........","8........","9........"};
        char [][] aa = new char[9][9];
        for(int i=0;i<a.length;i++){
            aa[i] = a[i].toCharArray();
        }

        System.out.println(isValidSudoku(aa));
    }
}
