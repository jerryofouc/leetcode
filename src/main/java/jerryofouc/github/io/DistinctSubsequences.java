package jerryofouc.github.io;

/**
 * f(x,y) = 0 if(x= 0 or y=0)
 *          1+f(x-1,y-1) + f(x-1,y) if S[x] = T[y]
 *          f(x-1,y)    if S[x] != T[y]
 * User: zhangxiaojie
 * Date: 3/23/14
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class DistinctSubsequences {
    public static int numDistinct(String S, String T) {
        byte[] byteS = S.getBytes();
        byte[] byteT = T.getBytes();
        int[][] relult = new int[byteS.length+1][byteT.length+1];
        for(int i = 0; i< byteS.length+1;i++){
            relult[i][0] = 1;
        }
        for(int i=0;i<S.length();i++){
            for(int j=0;j<T.length();j++){
                if(byteS[i] == byteT[j]){
                    relult[i+1][j+1] = relult[i][j] + relult[i][j+1];
                }else{
                    relult[i+1][j+1] = relult[i][j+1];
                }
            }
        }
        return relult[byteS.length][byteT.length];
    }

    public static void main(String args[]){
        System.out.println(numDistinct("ccc","c"));
    }


}
