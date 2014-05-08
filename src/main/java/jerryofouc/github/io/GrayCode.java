package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/5/14
 * Time: 9:22
 * To change this template use File | Settings | File Templates.
 */
public class GrayCode {
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> retValue = new ArrayList<Integer>();
        retValue.add(0);
        if(n==0){
            return retValue;
        }
        for(int i=1;i<=n;i++){
           for(int j=(1<<(i-1))-1;j>=0;j--){
               retValue.add(retValue.get(j)+(1<<(i-1)));
           }
        }
        return retValue;
    }

    public static void main(String args[]){
        System.out.println(grayCode(3));;
    }
}
