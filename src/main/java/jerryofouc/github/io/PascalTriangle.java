package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/18/14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class PascalTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        if(numRows == 0){
            return new ArrayList<ArrayList<Integer>>();
        }
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        arrayLists.add(first);
        for(int i=1;i<numRows;i++){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for(int j=1;j<i;j++){
                cur.add(arrayLists.get(i-1).get(j-1) + arrayLists.get(i-1).get(j));
            }
            cur.add(1);

            arrayLists.add(cur);
        }
        return arrayLists;
    }

    public static void main(String args[]){
        System.out.println(generate(3));
    }
}
