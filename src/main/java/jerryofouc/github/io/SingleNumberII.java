package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/23/14
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumberII {
    public static int singleNumber(int[] A){
        int result[] = new int[32];
        for(int a : A){
            for(int i=0;i<32;i++){
                result[i] = (result[i] + (a&1))%3;
                a >>= 1;
            }
        }

        int retVal = 0;
        int count = 1;
        for(int i=0;i<32;i++){
            retVal |= result[i]*count;
            count <<= 1;
        }
        return retVal;
    }


    public static void main(String args[]) {
        int A[] = {3,3,3,2,2,2,-111,5,5,5} ;
        System.out.println(singleNumber(A));
    }
}
