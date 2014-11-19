package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-14 23:36
 *         功能介绍:
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicates(int[] A) {
        if(A == null){
            return 0;
        }
        if(A.length == 1 || A.length == 0){
            return A.length;
        }

        int count = 1;
        int equalTime = 0;
        int last = A[0];
        int curIndex = 1;
        for(int i=1;i<A.length;i++){
            if(A[i] == last){
                equalTime++;
                if(equalTime < 2){
                    count++;
                    A[curIndex++] = A[i];
                }
            }else {
                A[curIndex++] = A[i];
                equalTime =0;
                count++;
            }
            last = A[i];
        }
        return count;
    }

    public static void main(String args[]){
        int[] A = {1,1,1,2,2,3};
        System.out.println(removeDuplicates(A));
    }
}
