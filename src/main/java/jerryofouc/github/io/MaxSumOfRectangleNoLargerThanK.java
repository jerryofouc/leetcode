package jerryofouc.github.io;

import java.util.TreeSet;

/**
 * Created by xiaojiez on 2/26/17.
 */
public class MaxSumOfRectangleNoLargerThanK {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0){
            return 0;
        }
        int m = Math.min(matrix.length,matrix[0].length);
        int n = Math.max(matrix.length,matrix[0].length);

        boolean isRowMin = matrix.length<=matrix[0].length;

        int result = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            int[] array = new int[n];
            for(int j=i;j>=0;j--){
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0);
                int value = 0;
                for(int t=0;t<n;t++){
                    array[t] = array[t] + (isRowMin?matrix[j][t]:matrix[t][j]);
                    value = value + array[t];
                    Integer sub = treeSet.ceiling(value-k);
                    if(sub!=null && value-sub>result){
                        result = value-sub;
                    }
                    treeSet.add(value);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,2,-1}};
        System.out.println(maxSumSubmatrix(matrix,3));
    }
}
