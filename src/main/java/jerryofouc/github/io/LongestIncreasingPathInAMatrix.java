package jerryofouc.github.io;

/**
 * Created by xiaojiez on 2/18/17.
 */
public class LongestIncreasingPathInAMatrix {
    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int[][] mem = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int l = findLongest(matrix,i,j,mem);
                if(max < l){
                    max = l;
                }
            }
        }
        return max;
    }

    private static int findLongest(int[][] matrix, int i, int j, int[][] mem) {
        if(mem[i][j] != 0){
            return mem[i][j];
        }
        int max = 1;
        if(j+1 < matrix[0].length){
            if(matrix[i][j] < matrix[i][j+1]){
                int l = findLongest(matrix,i,j+1,mem);
                if(max < l+1){
                    max = l+1;
                }
            }
        }
        if(j-1 >=0){
            if(matrix[i][j] < matrix[i][j-1]){
                int l = findLongest(matrix,i,j-1,mem);
                if(max < l+1){
                    max = l+1;
                }
            }
        }
        if(i+1 <matrix.length){
            if(matrix[i][j] < matrix[i+1][j]){
                int l = findLongest(matrix,i+1,j,mem);
                if(max < l+1){
                    max = l+1;
                }
            }
        }

        if(i-1 >=0){
            if(matrix[i][j] < matrix[i-1][j]){
                int l = findLongest(matrix,i-1,j,mem);
                if(max < l+1){
                    max = l+1;
                }
            }
        }

        mem[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        int[][] maxtrix = new int[][]{
                {3,4,5},
            {3,2,6},
            {2,2,1}
        };
        System.out.println(longestIncreasingPath(maxtrix));
    }

}
