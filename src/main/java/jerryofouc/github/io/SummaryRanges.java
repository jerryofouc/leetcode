package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaojiez on 1/26/17.
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        List<String> result =  summaryRanges(0,nums.length-1,nums);
        List<String> ret = new ArrayList<>();
        for(String r : result){
            String[] a = r.split("->");
            String temp;
            if(a.length==1){
                temp = nums[Integer.parseInt(a[0])]+"";
            }else {
                temp = nums[Integer.parseInt(a[0])]+"->"+nums[Integer.parseInt(a[1])];
            }

            ret.add(temp);
        }

        return ret;
    }

    private static List<String> summaryRanges(int start, int end, int[] nums) {
        List<String> list = new ArrayList<>();
        if(end-start == nums[end]-nums[start]){
            if(end == start){
                list.add(start+"") ;
            }else {
                list.add(start+"->"+end);
            }
            return list;
        }else {
            int mid = (start+end)/2;
            List<String> left ;
            if(start>mid-1){
                left = new ArrayList<>();
            }else {
                left = summaryRanges(start,mid-1,nums);
            }
            List<String> right;
            if(mid+1>end){
                right = new ArrayList<>();
            }else {
                right = summaryRanges(mid+1,end,nums);
            }
            String leftMost = mid+"";
            if(!left.isEmpty()){
                String ll = left.get(left.size()-1);
                String[] a = ll.split("->");
                if(nums[mid]-(nums[Integer.parseInt(a[a.length-1])]) == 1){
                    leftMost =(a[0])+"";
                    left.remove(left.size()-1);

                }
            }


            String rightMost = mid+"";
            if(!right.isEmpty()){
                String rr = right.get(0);
                String[] a = rr.split("->");
                if(nums[Integer.parseInt(a[0])]-nums[mid] == 1){
                    rightMost =  a[a.length-1]+"";
                    right.remove(0);
                }
            }
            String k = leftMost;
            if(rightMost.length()>0){
                if(!leftMost.equals(rightMost)){
                    k = k+"->"+rightMost;
                }
            }

            List<String> result = new ArrayList<>();
            result.addAll(left);
            result.add(k);
            result.addAll(right);
            return result;
        }
    }

    public static void main(String[] args) {
        int [] nums = new int[]{0,1,2,4,5,7,9,10,12,14,15,16,27,28};
        System.out.println(summaryRanges(nums));
    }
}
