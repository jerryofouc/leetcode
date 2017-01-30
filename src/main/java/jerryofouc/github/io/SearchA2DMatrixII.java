package jerryofouc.github.io;

/**
 * Created by xiaojiez on 1/27/17.
 */
public class SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0){
            return false;
        }
        return searchMatrix(matrix,0,0,matrix.length-1,matrix[0].length-1,target);
    }

    private static boolean searchMatrix(int[][] matrix, int si, int sj, int ei, int ej, int target) {
        if(ei<0||ej<0){
            return false;
        }
        if(matrix[ei][ej]<target){
            return false;
        }
        if(matrix[ei][ej]==target){
            return true;
        }
        if(si == ei && sj == ej){
            if(target == matrix[si][sj]){
                return true;
            }else {
                return false;
            }
        }
        int s = si,e = ei;

        while (s<=e){
            int mid = (s+e)/2;
            if(matrix[mid][ej]> target){
                e = mid-1;
            }else if(matrix[mid][ej] < target){
                s = mid+1;
            }else {
                return true;
            }
        }






        int s1 = sj,e1 = ej;
        while (s1<=e1){
            int mid = (s1+e1)/2;
            if(matrix[ei][mid]> target){
                e1 = mid-1;
            }else if(matrix[ei][mid] < target){
                s1 = mid+1;
            }else {
                return true;
            }
        }




        return searchMatrix(matrix,s,s1,ei-1,ej-1,target);


    }

    public static void main(String[] args) {
        int matrix[][] = new int[][]{
                {1,   4,  7, 11, 15}
        };

        System.out.println(searchMatrix(matrix,5));
    }
}
