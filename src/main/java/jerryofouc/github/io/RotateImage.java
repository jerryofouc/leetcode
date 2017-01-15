package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/15/17.
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        for(int i=0;i<=matrix.length/2;i++){
            for(int j=i;j<matrix.length-1-i;j++){
                int lastI = i,lastJ = j;
                int tempLast = matrix[lastI][lastJ];
                for(int k =0 ;k<4;k++){
                    int nextI = lastJ,nextJ = matrix.length-1-lastI;
                    int temp = matrix[nextI][nextJ];
                    matrix[nextI][nextJ] = tempLast;
                    tempLast = temp;
                    lastI = nextI;
                    lastJ = nextJ;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15}
        };
        rotate(matrix);
    }
}
