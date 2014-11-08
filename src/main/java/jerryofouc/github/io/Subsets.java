package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangxiaojie
 *         2014-11-08 01:07
 *         功能介绍:
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] S) {
        List<List<List<Integer>>> lists = new  ArrayList<List<List<Integer>>>();
        List<List<Integer>> first = new ArrayList<List<Integer>>();
        for(int i=0;i<S.length;i++){
            List<Integer> l = new ArrayList<Integer>() ;
            l.add(i);
            first.add(l);
        }
        lists.add(first);

        for(int i= 1;i<S.length;i++){
            List<List<Integer>> ll = new ArrayList<List<Integer>>();
            List<List<Integer>> lastLl = lists.get(i-1);
            for(List<Integer> l : lastLl){
                int lastIndex = l.get(l.size()-1);
                for(int j = lastIndex+1;j<S.length;j++){
                    List<Integer> nl = new ArrayList<Integer>();
                    nl.addAll(l);
                    nl.add(j);
                    ll.add(nl);
                }
            }
            lists.add(ll);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ret.add(new ArrayList<Integer>());
        for(List<List<Integer>> ll : lists){
            for(List<Integer> l : ll){
                List<Integer> r = new ArrayList<Integer>();
                for(Integer index : l){
                    r.add(S[index]);
                }
                ret.add(r);
                Collections.sort(r);
            }
        }

        return ret;
    }

    public static void main(String args[]){
        int aa[] = {1,2,3};
        System.out.println(subsets(aa));
    }
}
