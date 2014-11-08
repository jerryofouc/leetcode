package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/21/14
 * Time: 11:18
 * To change this template use File | Settings | File Templates.
 */
public class TwoSum {

    static class Pair implements Comparable<Pair>{
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        int value;
        int index;


        @Override
        public int compareTo(Pair o) {
            if(this.value < o.value || (this.value == o.value && this.index < o.index)){
                return -1;
            }else if(this.value>o.value|| (this.value == o.value && this.index > o.index)){
                return 1;
            }else {
                 return 0;
            }
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        ArrayList<Pair> pairArrayList = new ArrayList<Pair>();
        for(int i = 0;i<numbers.length;i++){
            pairArrayList.add(new Pair(numbers[i],i));
        }

        int[] result = new int[2];
        Collections.sort(pairArrayList);

        for(int i=0;i<pairArrayList.size()-1;i++){
            int start = i+1;
            int end =  pairArrayList.size()-1;
            int targetValue = target-pairArrayList.get(i).value;
            while(start<=end){
                int mid = (start+end)/2;
                int midValue = pairArrayList.get(mid).value;
                if(midValue  == targetValue){
                    result[0] = pairArrayList.get(i).index+1;
                    result[1] = pairArrayList.get(mid).index+1;
                    if(result[0] > result[1]){
                        int temp = result[1];
                        result[1]  = result[0];
                        result[0] = temp;
                    }
                    return result;
                }else if(midValue < targetValue){
                    start = mid +1;
                }else {
                    end = mid-1;
                }
            }
        }
        return result;
    }
    public static void main(String args[]){
        int num[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(num,target));
    }



}
