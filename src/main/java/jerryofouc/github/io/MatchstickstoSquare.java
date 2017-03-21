package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 3/20/17.
 */
public class MatchstickstoSquare {
    public static boolean makesquare(int[] nums) {
        if(nums.length<4){
            return false;
        }
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%4 != 0){
            return false;
        }


        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();
            int firstSum = 0;
            for(int j=0;j<nums.length;j++){
                if(((1<<j)&i)!=0){
                    firstSum += nums[j];
                    firstList.add(nums[j]);
                }else {
                    secondList.add(nums[j]);
                }
            }
            if(firstSum==sum/2){
                 if(canEqualSplit(firstList,firstSum)&&canEqualSplit(secondList,firstSum)){
                     return true;
                 }
            }
        }
        return false;
    }

    private static boolean canEqualSplit(List<Integer> list,int sum) {
        for(int i=0;i<(1<<list.size());i++){
            int firstSum = 0;
            int j=0;
            for(;j<list.size();j++){
                if(((1<<j)&i)!=0){
                    firstSum += list.get(j);
                }
            }
            if(firstSum == sum/2){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2,2,2,2,2,6};
        System.out.println(makesquare(num));
    }
}
