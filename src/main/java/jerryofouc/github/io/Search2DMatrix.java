package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-19 19:31
 *         功能介绍:
 */
public class Search2DMatrix {

    public static void main(String args[]){
        int[][] maxtrix = {{1,3}};
        searchMatrix(maxtrix,3);

    }
    private static class Coo{
        int row;
        int column;

        private Coo(int row, int column) {
            this.row = row;
            this.column = column;
        }


    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null ||  matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int begin = 0;
        int end = row*column-1;

        while(begin<=end){
            int mid = (begin+end)/2;
            Coo coo = getCoo(mid,column);

            if(matrix[coo.row][coo.column] == target){
                return true;
            }else if(matrix[coo.row][coo.column] > target){
                end = mid-1;
            }else {
                begin = mid+1;
            }
        }
        return false;
    }

    private static Coo getCoo(int n,int k){
        int x = n / k;
        int y = n % k;
        return new Coo(x, y);
    }


}
