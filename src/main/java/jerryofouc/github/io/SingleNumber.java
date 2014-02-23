package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/22/14
 * Time: 15:36
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int result = 0;
        for(int i : A){
            result ^= i;
        }
        return result;
    }
}
