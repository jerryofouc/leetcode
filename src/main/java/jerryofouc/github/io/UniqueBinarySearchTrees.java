package jerryofouc.github.io;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/7/14
 * Time: 9:56
 * To change this template use File | Settings | File Templates.
 */
public class UniqueBinarySearchTrees {

    public static int numTrees(int n) {
        int[] temp = new int[n+1];
        temp[0] = 1;
        temp[1] = 1;
        for(int i=2;i<=n;i++){
            temp[i] = 0;
            for(int j=0;j<i;j++){
                temp[i] += temp[j]*temp[i-1-j];
            }
        }
        return temp[n];
    }

    public static void main(String args[]){
        System.out.println(numTrees(3));
    }
}
