package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/15/17.
 */
public class SpiralMatrixOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new ArrayList<Integer>();
        }
        List<Integer> result = new ArrayList<Integer>();
        int[][] record = new int[matrix.length][matrix[0].length];
        int i=0,j=0, direction = 0;
        while (true){
            result.add(matrix[i][j]);
            record[i][j] = 1;
            if(direction == 0){
                if(j+1<matrix[0].length&&record[i][j+1]!=1){
                    j++;
                }else {
                    direction = 1;
                    if(i+1<matrix.length&&record[i+1][j] != 1){
                        i++;
                    }else {
                        break;
                    }
                }
            }else if(direction == 1){
                if(i+1<matrix.length&&record[i+1][j]!=1){
                    i++;
                }else {
                    direction = 2;
                    if(j-1>=0&&record[i][j-1] != 1){
                        j--;
                    }else {
                        break;
                    }
                }
            }else if(direction == 2){
                if(j-1>=0&&record[i][j-1] != 1){
                    j--;
                }else {
                    direction = 3;
                    if(i>=0&&record[i-1][j] != 1){
                        i--;
                    }else {
                        break;
                    }
                }
            }else if(direction == 3){
                if(i>=0&&record[i-1][j] != 1){
                    i--;
                }else {
                    direction = 0;
                    if(j+1<matrix[0].length&&record[i][j+1]!=1){
                        j++;
                    }else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] maxtrix = new int[][]{
                {2,3}

        };
        System.out.println(spiralOrder(maxtrix));
    }
}
