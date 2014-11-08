package jerryofouc.github.io;

/**
 * @author zhangxiaojie
 *         2014-11-07 23:22
 *         功能介绍:
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] A) {
        int b=1, f=1, res=Integer.MIN_VALUE;
        for(int i=0; i<A.length; i++){
            res=Math.max(res, Math.max(b*=A[i],f*=A[A.length-1-i]));
            if(b==0) b=1; if(f==0) f=1;
        }
        return res;
    }

    public static void main(String args[]) {
        int[] a = {2,3,-2,4};
        System.out.println(maxProduct(a));
    }
}
