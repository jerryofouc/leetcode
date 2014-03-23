package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/18/14
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
public class PascalTriangleII {
    public static ArrayList<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex+1;
        if(rowIndex == 0){
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> last = new ArrayList<Integer>();
        last.add(1);
        for(int i=1;i<rowIndex;i++){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for(int j=1;j<i;j++){
                cur.add(last.get(j - 1) + last.get(j));
            }
            cur.add(1);
            last = cur;
        }
        return last;
    }
    public static void main(String args[]){
        System.out.println(getRow(5));
    }
}
