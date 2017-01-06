package jerryofouc.github.io;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaojiezhang on 1/6/17.
 * 1.就像是八皇后问题,分解为子问题递归地尝试。
 * 2.分解为以下子问题:
 *    如果是数字则不进行尝试
 *    否则则尝试从1-9赋值,如果其中一个可行,则继续尝试下一个格子。
 *    如果这个格子不行,则需要回溯,回溯需要赋值回'.'
 */
public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        solveSudoku(0,0,board);
    }

    private static boolean solveSudoku(int i, int j, char[][] board) {
        if(i==9){
            return true;
        }

        if(board[i][j] != '.'){
            if(j+1 == 9){
                j = 0;
                i ++;
            }else {
                j++;
            }
            return solveSudoku(i,j,board);
        }else {
            for(char p='1';p<='9';p++){
                board[i][j] = p;
                Set<Character> set = new HashSet<Character>();
                boolean isOK = true;
                for(int k = 0;k<9;k++){
                    char current = board[i][k];
                    if( current>='1' && current<='9'){
                        if(!set.contains(current)){
                            set.add(current);
                        }else {
                            isOK = false;
                            break;
                        }
                    }
                }
                set.clear();
                for(int k = 0;k<9;k++){
                    char current = board[k][j];
                    if(current >='1' && current<='9'){
                        if(!set.contains(current)){
                            set.add(current);
                        }else {
                            isOK = false;
                            break;
                        }
                    }
                }
                set.clear();

                int a = i/3*3,b = j/3*3;
                for(int k=a;k<a+3;k++){
                    for(int q=b;q<b+3;q++){
                        char current = board[k][q];

                        if(current >='1' && current<='9'){
                            if(!set.contains(current)){
                                set.add(current);
                            }else {
                                isOK = false;
                                break;
                            }
                        }
                    }
                }
                set.clear();
                int nextI ,nextJ;
                if(j+1 == 9){
                    nextJ = 0;
                    nextI = i+1;
                }else {
                    nextI = i;
                    nextJ = j+1;
                }
                if(isOK && solveSudoku(nextI,nextJ,board)){
                    return true;
                }
            }
            board[i][j] = '.';
            return false;
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{
            "..9748...", "7........",".2.1.9...",
                "..7...24.",".64.1.59.",
                ".98...3..","...8.3.2.",
                "........6","...2759.."};
        char [][] aa = new char[9][9];
        for(int i=0;i<a.length;i++){
            aa[i] = a[i].toCharArray();
        }

        solveSudoku(aa);
        System.out.println(aa);
    }



}
