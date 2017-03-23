package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length == 0){
            return new int[]{};
        }
        int count = 0;
        int[] result = new int[matrix.length*matrix[0].length];
        int direction = 0;
        for(int l=0;l<=matrix.length-1+matrix[0].length-1;l++){
            if(direction == 0){
                for(int i=matrix.length-1;i>=0;i--){
                    int j=l-i;
                    if(j>=0&&j<matrix[0].length){
                        result[count++] = matrix[i][j];
                    }
                }
                direction = 1;
            }else {
                for(int i=0;i<matrix.length;i++){
                    int j=l-i;
                    if(j>=0&&j<matrix[0].length){
                        result[count++] = matrix[i][j];
                    }
                }
                direction = 0;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        System.out.println(findDiagonalOrder(matrix));
    }


}
