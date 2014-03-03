package jerryofouc.github.io;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/2/14
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
        HashMap<Integer,Boolean> numMap = new HashMap<Integer, Boolean>() ;
        for(int i : num){
            numMap.put(i,false);
        }
        HashSet<Integer> numSet = new HashSet<Integer>();
        for(int i:num){
            numSet.add(i);
        }

        int max = 1;

        for(Integer i:numSet){
            Boolean value = numMap.get(i);
            if(value != null && !value){
                int curMax = 1;
                int cur = i+1;
                while(numSet.contains(cur)){
                    curMax++;
                    numMap.put(cur,true);
                    cur++;
                }
                cur = i-1;
                while(numSet.contains(cur)){
                    curMax++;
                    numMap.put(cur,true);
                    cur--;
                }

                if(max < curMax){
                    max = curMax;
                }
            }
        }
        return max;
    }

    public static void main(String args[]){
        int num[] = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(num));
    }

}
