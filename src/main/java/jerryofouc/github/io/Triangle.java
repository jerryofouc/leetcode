package jerryofouc.github.io;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/16/14
 * Time: 23:34
 * To change this template use File | Settings | File Templates.
 */
public class Triangle {
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int[] length = new int[triangle.get(triangle.size()-1).size()];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j = 0; j<=i-1;j++){
                length[j] = min(triangle.get(i).get(j),triangle.get(i).get(j+1));
            }
            for(int j=0;i-1>=0&&j<triangle.get(i-1).size();j++){
              triangle.get(i-1).set(j,triangle.get(i-1).get(j) + length[j]);
            }
        }
        return triangle.get(0).get(0);
    }
    public  static int min(int a,int b){
        return a<b?a:b;
    }

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayLists.add(arrayList);
        arrayList = new ArrayList<Integer>();
        arrayList.add(2);
        arrayList.add(3);
        arrayLists.add(arrayList);
//        arrayList = new ArrayList<Integer>();
//        arrayList.add(1);
//        arrayList.add(-1);
//        arrayList.add(-3);
//        arrayLists.add(arrayList);
        System.out.println(minimumTotal(arrayLists));
    }
}
