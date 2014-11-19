package jerryofouc.github.io;


import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiaojie
 *         2014-11-15 15:19
 *         功能介绍:
 */
public class Combinations {



    public static void main(String args[]){
        System.out.println(combine(2, 1));

    }

    public static List<List<Integer>> combine(int begin,int end,int k){
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(k == 0){
            return lists;
        }
        if(k == end-begin +1){
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for(int i= begin;i<=end;i++){
                arrayList.add(i);
            }
            lists.add(arrayList);
            return lists;
        }

        lists.addAll(combine(begin + 1, end, k));
        List<List<Integer>> llist = combine(begin+1,end,k-1);
        if(!llist.isEmpty()){
            for(List<Integer> l : llist){
                l.add(0,begin);
            }
            lists.addAll(llist);
        }else {
            List<Integer> l = new ArrayList<Integer>();
            l.add(begin);
            lists.add(l);
        }

        return lists;
    }

    public static List<List<Integer>> combine(int n, int k) {
        return combine(1,n,k);
    }
}
