package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/15/17.
 */
public class NQueensII {
    public static List<List<String>> solveNQueens(int n) {
        int[] validCol = new int[n];
        int[] validPos = new int[2*n-1];
        int[] validNeg = new int[2*n-1];
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> current = new ArrayList<String>();

        solveNQueens(result,current,n,0,validCol,validPos,validNeg);
        return result;
    }

    private static void solveNQueens(List<List<String>> result,List<String> current, int n, int row, int[] validCol, int[] validPos, int[] validNeg) {
        for(int col=0;col<n;col++){
            if(validCol[col] == 0 && validPos[row+col] == 0 && validNeg[col-row+n-1] ==0){
                String r = "";
                for(int k=0;k<n;k++){
                    if(k == col){
                        r = r+"Q";
                    }else {
                        r = r + ".";
                    }
                }
                current.add(r);
                if(row == n-1){
                    result.add(new ArrayList<String>(current));
                    current.remove(current.size()-1);
                }else {
                    validCol[col] = 1;
                    validPos[row+col] = 1;
                    validNeg[col-row+n-1] = 1;
                    solveNQueens(result,current,n,row+1,validCol,validPos,validNeg);
                    validCol[col] = 0;
                    validPos[row+col] = 0;
                    validNeg[col-row+n-1] = 0;
                    current.remove(current.size()-1);
                }
            }
        }
    }
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }
}
