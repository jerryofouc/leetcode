package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 4/8/14
 * Time: 23:27
 * To change this template use File | Settings | File Templates.
 */
public class SubsetsII {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        Set<ArrayList<Integer>> arrayListSet= addToSubSet(0, num);
        return new ArrayList<ArrayList<Integer>>(arrayListSet);
    }

    private static Set<ArrayList<Integer>> addToSubSet(int i, int[] num) {
        Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if(i == num.length-1){
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(num[i]);
            set.add(arrayList);
            set.add(new ArrayList<Integer>());
        }else{
            Set<ArrayList<Integer>> subSet = addToSubSet(i+1,num);
            set.addAll(subSet);
            for(ArrayList<Integer> arrayList :subSet){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]);
                temp.addAll(arrayList);
                set.add(temp);
            }
        }
        return set;
    }

    public static void main(String args[]){
        int[] num = {1,2,2};
        System.out.println(subsetsWithDup(num));
    }

}
