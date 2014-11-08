package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-08 00:03
 *         功能介绍:
 */
public class FindMinimumRotatedSortedArray {
    public static int findMin(int[] num) {
        int L = 0,R = num.length-1;
        while(L<R && (num[L] > num[R]||num[L] == num[R])){
            int M = (L+R)/2;
            if(num[L] < num[M]){
                L = M+1;
            }else if(num[L]>num[M]){
                R = M;
            }else {
                L++;
            }
        }
        return num[L];
    }

    public static void main(String args[]){
        int a[] = {3,3,1,3,3,3,3};
        System.out.println(findMin(a));
    }
}
