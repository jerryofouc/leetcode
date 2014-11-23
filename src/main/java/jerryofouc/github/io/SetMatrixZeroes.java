package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-19 19:59
 *         功能介绍:
 */
public class SetMatrixZeroes {
    public static void main(String args[]){
        int[][] matrix = {{1,0}};
       setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        for(int i = 1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                for(int j=1;j<matrix[i].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i] == 0){
                for(int j=1;j<matrix.length;j++){
                    matrix[j][i] = 0;
                }
            }
        }

        if(firstColumnZero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }

        if(firstRowZero){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }

    }
}
